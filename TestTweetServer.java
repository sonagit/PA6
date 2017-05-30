import tester.*;

/**
 * Testing time
 */
class TestTweetServer {
  
  // Bring in sample tweets tweetlist and user array
  SampleTweets st = new SampleTweets();
  TweetList stl = new SampleTweets().t;
  User[] su = new SampleTweets().users;
  
  // test addUser
  boolean testAddUser(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    boolean userSuccess = ts.addUser("amyhoy", "Amy Hoy");
    return  t.checkExpect(userSuccess, false) &&
            t.checkExpect(ts.users, this.su);
  }

  // test addTextTweet
  boolean testAddTextTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    boolean textSuccess = ts.addTextTweet("amyhoy", "ew", new DateTime(2,2,2016));
    return  t.checkExpect(textSuccess, true);/* &&
            t.checkExpect(ts., this.su);//*/
  }
  
  // test addImageTweet
  boolean testAddImageTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    boolean imageSuccess = ts.addImageTweet("amyhoy", "ew", "thisisaURL", 1000, new DateTime(2,2,2016));
    return  t.checkExpect(imageSuccess, true);/* &&
            t.checkExpect(ts., this.su);//*/
  }
  
  // test quoteTweet
  boolean testQuoteTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    boolean quoteSuccess = ts.quoteTweet("kobebryant", "852984006815731712", "ew", new DateTime(2,2,2016));
    return  t.checkExpect(quoteSuccess, true);/* &&
            t.checkExpect(ts., this.su);//*/
  }

  // test likeTweet
  boolean testLikeTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    return  t.checkExpect(ts.likeTweet("852984006815731712"), true) &&
            t.checkExpect(ts.likeTweet("852984"), false);/* &&
            t.checkExpect(ts., this.su);//*/
  }

  // test getTweets
  boolean testgetTweets(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    return  t.checkExpect(ts.getTweets("don't matter"), this.stl) &&
            t.checkExpect(ts.getTweets("?contains=Kawhi"),
            new TLLink(this.st.textTweet4, new TLEmpty()));
  }
  
  // test getTweetsHTML
  // create tweet server
  TweetServer ts = new TweetServer(this.stl, this.su);
  //System.out.println(ts.getTweetsHTML("whatever"));
  String html4REAL = ts.getTweetsHTML("whatever");

  // test parse
  boolean testParse(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    return  t.checkExpect(ts.parse("won't work"), new AllQuery()) &&
            t.checkExpect(ts.parse("?contains=rabbits"), new ContainsQuery("rabbits")) &&
            t.checkExpect(ts.parse("?contains=rabbits&contains=the"),
            new AndQuery(new ContainsQuery("the"),
            new ContainsQuery("rabbits")));//*/
  }
}
