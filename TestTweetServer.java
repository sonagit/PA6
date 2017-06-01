import tester.*;

/**
 * Testing time
 */
class TestTweetServer {

  // Bring in sample tweets tweetlist and user array
  SampleTweets st = new SampleTweets();
  TweetList stl = new SampleTweets().t;
  User[] su = new SampleTweets().users;

  // create a TweetList
  TweetList tl1 = new TLLink(st.textTweet1, new TLLink(st.textTweet2, new TLEmpty()));

  TextTweet myTTweet = new TextTweet(new User("amyhoy", "Amy Hoy"), new DateTime(2,2,2016), "ew", "1", 0);
  ImageTweet myITweet = new ImageTweet(new User("amyhoy", "Amy Hoy"), new DateTime(2,2,2016), "ew", "1", "thisisaURL", 1000);
  TweetList tl1FinalT = new TLLink(myTTweet, new TLLink(st.textTweet1, new TLLink(st.textTweet2, new TLEmpty())));
  TweetList tl1FinalI = new TLLink(myITweet, new TLLink(st.textTweet1, new TLLink(st.textTweet2, new TLEmpty())));

  // create user array to accompnay
  User tl1u[] = {new User("amyhoy","Amy Hoy"), new User("ghc","Grace Hopper(GHC)")};
  User tl1Finalu[] = {
    new User("amyhoy","Amy Hoy"),
    new User("ghc","Grace Hopper(GHC)"),
    new User("stubaby", "Baby Stu"),
    new User("thirdTry", "Dunno why")
  };

  // test addUser
  boolean testAddUser(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    TweetServer ts1 = new TweetServer(this.tl1, this.tl1u);
    boolean userSuccess1 = ts.addUser("amyhoy", "Amy Hoy");
    boolean userSuccess2 = ts1.addUser("stubaby", "Baby Stu");
    boolean userSuccess3 = ts1.addUser("thirdTry", "Dunno why");
    return  t.checkExpect(userSuccess1, false) &&
            t.checkExpect(userSuccess2, true) &&
            t.checkExpect(userSuccess3, true) &&
            t.checkExpect(ts.users, this.su) &&
            t.checkExpect(ts1.users, this.tl1Finalu);
}

  // test addTextTweet
  boolean testAddTextTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    TweetServer ts1 = new TweetServer(this.tl1, this.tl1u);
    boolean textSuccess1 = ts.addTextTweet("amyhoy", "ew", new DateTime(2,2,2016));
    boolean textSuccess2 = ts1.addTextTweet("amyhoy", "ew", new DateTime(2,2,2016));
    boolean textSuccess3 = ts1.addTextTweet("amy", "ew", new DateTime(2,2,2016));
    return  t.checkExpect(textSuccess1, true) &&
            t.checkExpect(textSuccess2, true) &&
            t.checkExpect(textSuccess3, false) &&
            t.checkExpect(ts1.tweets, tl1FinalT);//*/
  }

  // test addImageTweet
  boolean testAddImageTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    TweetServer ts1 = new TweetServer(this.tl1, this.tl1u);
    boolean imageSuccess1 = ts.addImageTweet("amyhoy", "ew", "thisisaURL", 1000, new DateTime(2,2,2016));
    boolean imageSuccess2 = ts1.addImageTweet("amyhoy", "ew", "thisisaURL", 1000, new DateTime(2,2,2016));
    boolean imageSuccess3 = ts.addImageTweet("amy", "ew", "thisisaURL", 1000, new DateTime(2,2,2016));
    return  t.checkExpect(imageSuccess1, true) &&
            t.checkExpect(imageSuccess2, true) &&
            t.checkExpect(imageSuccess3, false) &&
            t.checkExpect(ts1.tweets, tl1FinalI);//*/
  }

  // test quoteTweet
  boolean testQuoteTweet(Tester t) {
    // st.textTweet2.quote(this.tl1u[0], new DateTime(2,2,2016),"ew");
    QuoteTweet qTweet = new QuoteTweet(this.tl1u[0], new DateTime(2,2,2016), "ew", "849290510049071106-rt", st.textTweet2);
    TweetList tl1Final = new TLLink(qTweet, new TLLink(st.textTweet1, new TLLink(st.textTweet2, new TLEmpty())));
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    TweetServer ts1 = new TweetServer(this.tl1, this.tl1u);
    boolean quoteSuccess1 = ts.quoteTweet("kobebryant", "852984006815731712", "ew", new DateTime(2,2,2016));
    boolean quoteSuccess2 = ts1.quoteTweet("amyhoy", "849290510049071106", "ew", new DateTime(2,2,2016));
    boolean quoteSuccess3 = ts1.quoteTweet("kobe", "852984006815731712", "ew", new DateTime(2,2,2016));
    return  t.checkExpect(quoteSuccess1, true) &&
            t.checkExpect(quoteSuccess2, true) &&
            t.checkExpect(quoteSuccess3, false);/* &&
            t.checkExpect(ts1.tweets, tl1Final);//*/
  }

  // test likeTweet
  boolean testLikeTweet(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    TweetServer ts1 = new TweetServer(this.tl1, this.tl1u);
    return  t.checkExpect(ts.likeTweet("852984006815731712"), true) &&
            t.checkExpect(ts1.likeTweet("852984006815731712"), true) &&
            t.checkExpect(ts.likeTweet("852984"), false) &&
            t.checkExpect(st.textTweet1.likes, 3);//*/
  }

  // test getTweets
  boolean testgetTweets(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    return  t.checkExpect(ts.getTweets("don't matter"), this.stl) &&
            t.checkExpect(ts.getTweets("/tweets?contains=Kawhi"),
            new TLLink(this.st.textTweet4, new TLEmpty()))&&
            t.checkExpect(ts.getTweets("/tweets?user=android_robin"),
            new TLLink(this.st.imageTweet4, new TLEmpty()));
  }

  // test parse
  boolean testParse(Tester t) {
    // create tweet server
    TweetServer ts = new TweetServer(this.stl, this.su);
    return  t.checkExpect(ts.parse("won't work"), new AllQuery()) &&
            t.checkExpect(ts.parse("/tweets?contains=rabbits"), new ContainsQuery("rabbits")) &&
            t.checkExpect(ts.parse("/tweets?contains=rabbits&contains=the"),
            new AndQuery(new ContainsQuery("the"),
            new ContainsQuery("rabbits")));//*/
  }
}
