interface IQuery {
  boolean matches(ATweet atweet);
  default IQuery and(IQuery other) {
    return new AndQuery(this, other);
  }
}

class AndQuery implements IQuery {
  IQuery q1, q2;
  AndQuery(IQuery q1, IQuery q2) {
    this.q1 = q1;
    this.q2 = q2;
  }
  public boolean matches(ATweet atweet) {
    return this.q1.matches(atweet) && this.q2.matches(atweet);
  }
}

class AllQuery implements IQuery {
  public boolean matches(ATweet atweet) { return true; }
}
class ContainsQuery implements IQuery {
  String searchString;
  ContainsQuery(String searchString) {
    this.searchString = searchString;
  }
  public boolean matches(ATweet atweet) {
    return atweet.getContent().contains(this.searchString);
  }
}
class BeforeQuery implements IQuery {
  DateTime date;
  BeforeQuery(DateTime date) {
    this.date = date;
  }
  public boolean matches(ATweet atweet) {
    return atweet.getTimestamp().earlierThan(this.date);
  }
}
class UserQuery implements IQuery{
  String username;
  UserQuery(String username){
    this.username=username;
  }
  public boolean matches(ATweet atweet){
    return atweet.getUsername().equals(this.username);
  }
}
class IdQuery implements IQuery{
  String tweetId;
  IdQuery(String tweetId) {
    this.tweetId = tweetId;
  }
  public boolean matches(ATweet atweet){
    return atweet.getTweetId().equals(this.tweetId);
  }
}
