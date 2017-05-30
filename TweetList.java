interface TweetList {
  TweetList filter(IQuery q);
//  ATweet tweet;
  int count(IQuery q);
  String toHTML();
  int length();
}

class TLLink implements TweetList{
  TweetList rest;
  ATweet tweet;
  TLLink(ATweet tweet, TweetList rest){
    this.tweet = tweet;
    this.rest=rest;
  }
  public TweetList filter(IQuery q){
    if(q.matches(tweet)){
      return new TLLink(tweet,this.rest.filter(q));
    } else {
      return this.rest.filter(q);
    }
  }
  public int count(IQuery q){
    if(q.matches(tweet)){
      return 1 + rest.count(q);
    } else {
      return rest.count(q);
    }
  }
  public String toHTML(){
    return tweet.toHTML()+"\n"+this.rest.toHTML();
  }

  public int length(){
    return 1 + rest.length();
  }

}

class TLEmpty implements TweetList{
  ATweet tweet;
  TLEmpty(){
  }
  public TweetList filter(IQuery q){
    return new TLEmpty();
  }
  public int count(IQuery q){
    return 0;
  }
  public String toHTML(){
    return "";
  }

  public int length(){
    return 0;
  }

}
