class TweetServer {
  TweetList tweets;
  User[] users;

  String htmlStart = "<html>\n<head>\n<meta charset='utf8'>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"tweetstyle.css\">\n</head>\n<body> ";
  String htmlEnd = "</body>\n</html>";

  TweetServer(TweetList tweets, User[] users) {
    this.tweets = tweets;
    this.users = users;
  }

  IQuery parse(String request) {
    return new AllQuery();
  }

  TweetList getTweets(String query) {
    return new TLEmpty();
  }

  String getTweetsHTML(String query) {
    return "";
  }

  boolean addUser(String username, String fullname) {
    return true;
  }

  boolean addTextTweet(String username, String content, DateTime dt) {
    return true;
  }

  boolean likeTweet(String tweetId) {
    return true;
  }

  boolean quoteTweet(String tweetId, String content, String username) {
    return true;
  }

}
