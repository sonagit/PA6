import tester.*;

class DateTime {
  int day;
  int month;
  int year;

  DateTime(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  String toHTML() {
    return "<p id='datetime'>" + this.day + "/" + this.month + "/" + this.year + "</p>";
  }

  boolean earlierThan(DateTime another) {
    if (this.year != another.year) {
      return (this.year < another.year);
    }
    else {
      if (this.month != another.month) {
        return (this.month < another.month);
      } else {
        return (this.day < another.day);
      }
    }
  }

  String approximateTimeTo(DateTime other) {
    if(this.year == other.year && this.month == other.month && this.day == other.day) {
      return "Today";
    }
    else if(this.year > other.year) {
      return this.year - other.year + " year(s) from now";
    }
    else if(this.year < other.year) {
      return other.year - this.year + " year(s) ago";
    }
    else if(this.month > other.month) {
      return this.month - other.month + " month(s) from now";
    }
    else if(this.month < other.month) {
      return other.month - this.month + " month(s) ago";
    }
    else if(this.day > other.day) {
      return this.day - other.day + " day(s) from now";
    }
    else {
      return other.day - this.day + " day(s) ago";
    }
  }
}

class User {

  String username;
  String fullname;

  User(String username, String fullname) {
    this.username = username;
    this.fullname = fullname;
  }

  String toHTML() {
    return "<a href='http://localhost:8000?user=" + this.username + "' id='handle'>" + this.fullname + " (@" + this.username + ")</a>";
  }


  boolean sameUser(User other){
    return this.username.equals(other.username) && this.fullname.equals(other.fullname);
  }
  String getUsername(){
    return this.username;
  }
}

abstract class ATweet{
  User user;
  DateTime timestamp;
  String content;
  String tweetId;
  int likes;
  int retweetCount;

  ATweet(User user, DateTime timestamp, String content, String tweetId) {
    this.user = user;
    this.timestamp = timestamp;
    this.content = content;
    this.tweetId = tweetId;
    this.likes = 0;
    this.retweetCount = 0;
  }

  ATweet(User user, DateTime timestamp, String content, String tweetId, int likes) {
    this.user = user;
    this.timestamp = timestamp;
    this.content = content;
    this.tweetId = tweetId;
    this.likes = likes;
    this.retweetCount = 0;
  }

  boolean earlierThan(ATweet other){
    return this.timestamp.earlierThan(other.timestamp);
  }

  void like() {
    this.likes += 1;
  }

  String getUsername(){
    return this.user.getUsername();
  }
  DateTime getTimestamp(){
    return this.timestamp;
  }
  String getContent(){
    return this.content;
  }
  String getTweetId(){
    return this.tweetId;
  }
  int getLikes(){
    return this.likes;
  }

  boolean hasHashTag(String hashtag){
    return this.content.contains(hashtag);
  }

  boolean hasLink(){
    return this.content.contains("http://");
  }

  String toLink(){
    return ("https://twitter.com/" + this.user.username + "/status/" + this.tweetId);
  }

  boolean sameUser(ATweet other){
    return this.user.username.equals(other.user.username);
  }

  QuoteTweet quote(User user, DateTime timestamp, String content){
    this.retweetCount += 1;
    String nextId = this.tweetId + "-rt" + this.retweetCount;
    return new QuoteTweet(user, timestamp, content, nextId, this);
  }

  abstract String summary();
  abstract String toHTML();
}

class TextTweet extends ATweet{
  TextTweet(User user, DateTime timestamp, String content, String tweetId, int likes) {
    super(user, timestamp, content, tweetId);
    this.likes = likes;
  }
  TextTweet(User user, DateTime timestamp, String content, String tweetId) {
    super(user, timestamp, content, tweetId);
  }

  String toHTML() {
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" + this.timestamp.toHTML() + "\n" + "<p>" + this.content + "</p>\n"
        + "<p id='likes'>" + this.likes + " likes</p>\n</div>";
  }

  boolean search(String toSearch){
    return (this.content.indexOf(toSearch) != -1);
  }

  String summary(){
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" +  "<p>" + this.content + " " + "</p>\n</div>";
  }
  String getType(){
    return "TextTweet";
  }
}


class ImageTweet extends ATweet{
  String imageURL;
  int imageKB;

  ImageTweet(User user, DateTime timestamp, String content, String tweetId, String imageURL, int imageKB, int likes) {
    super(user, timestamp, content, tweetId);
    this.imageURL = imageURL;
    this.imageKB = imageKB;
    this.likes = likes;
  }
  ImageTweet(User user, DateTime timestamp, String content, String tweetId, String imageURL, int imageKB) {
    super(user, timestamp, content, tweetId);
    this.imageURL = imageURL;
	this.imageKB = imageKB;
  }


  ImageTweet retweet(User user, DateTime timestamp) {
    return new ImageTweet(this.user, this.timestamp, this.content, this.tweetId + "-rt", this.imageURL, this.imageKB);
  }

  String toHTML() {
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" + this.timestamp.toHTML() + "\n" + "<p>" + this.content + "</p>"
        + "<img id='tweetimage' src='" + this.imageURL + "'>"
        + "<p id='likes'>" + this.likes + " likes</p>"
        + "\n</div>";
  }

  String summary(){
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" +  "<p>" + this.content + " " + "</p>\n</div>";
  }
  String getType(){
    return "imageTweet";
  }
}

class QuoteTweet extends ATweet{
  ATweet originalTweet;

  QuoteTweet(User user, DateTime timestamp, String content, String tweetId, ATweet originalTweet){
    super(user, timestamp, content, tweetId);
	this.originalTweet = originalTweet;
  }

  QuoteTweet(User user, DateTime timestamp, String content, String tweetId, ATweet originalTweet, int likes){
    super(user, timestamp, content, tweetId, likes);
	this.originalTweet = originalTweet;
  }

  String toHTML() {
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" + this.timestamp.toHTML() + "\n" + "<p>" + this.content + "</p>\n"
	    + originalTweet.summary() + "<p id='likes'>" + this.likes + " likes</p>\n</div>";
  }

  String summary(){
    return "<div id='tweet'>\n" + this.user.toHTML() + "\n" +  "<p>" + this.content + " " +
           "<a href='http://localhost:8000/tweets?id=" + this.tweetId + "'>http://localhost...</a></p>\n</div>";
  }
  String getType(){
    return "QuoteTweet";
  }
}
