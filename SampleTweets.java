
/*

  This file contains a bunch of example tweets which you can use as sample
  data by writing

    new SampleTweets().t

  which evaluates to a TweetList containing these Tweets.

*/

class SampleTweets{
  TweetList t;
  User[] users = {
    new User("amyhoy","Amy Hoy"),
    new User("kobebryant"," Kobe Bryant"),
    new User("android_robin", "Robin Lee"),
    new User("drose", "Derrick Rose"),
    new User("Dwyane Wade", "DWade"),
    new User("jollie12", "John Oliver"),
    new User("Markman", "Mark hemsworth"),
    new User("Lks21", "Luke Skywalker"),
    new User("UCSDJacobs", "UCSD Engineering"),
    new User("jollie12", "John Oliver"),
    new User("Markman", "Mark hemsworth"),
    new User("xkcdComic", "XKCD Comic"),
    new User("TheEllenShow", "Ellen DeGeneres"),
    new User("googleresearch", "Google Research"),
    new User("onfireScarlett","Sasha"),
    new User("fakeuser","Fake User"),
    new User("bunny","Mr. Bunny"),
    new User("onfireScarlett","Sasha"),
    new User("Starcraft Esports","esportstarcraft")
  };
  SampleTweets(){
    t = new TLEmpty();
    t= new TLLink(textTweet9,t);
    t= new TLLink(textTweet8,t);
    t= new TLLink(textTweet7,t);
    t= new TLLink(textTweet6,t);
    t= new TLLink(textTweet5,t);
    t= new TLLink(textTweet4,t);
    t= new TLLink(textTweet2,t);
    t= new TLLink(textTweet1,t);
    t= new TLLink(imageTweet11,t);
    t= new TLLink(imageTweet10,t);
    t= new TLLink(imageTweet9,t);
    t= new TLLink(imageTweet8,t);
    t= new TLLink(imageTweet7,t);
    t= new TLLink(imageTweet6,t);
    t= new TLLink(imageTweet5,t);
    t= new TLLink(imageTweet4,t);
    t= new TLLink(imageTweet2,t);
    t= new TLLink(imageTweet1,t);
    t= new TLLink(quoteTweet14,t);
    t= new TLLink(quoteTweet13,t);
    t= new TLLink(quoteTweet12,t);
    t= new TLLink(quoteTweet11,t);
    t= new TLLink(quoteTweet9,t);
    t= new TLLink(quoteTweet8,t);
    t= new TLLink(quoteTweet7,t);
    t= new TLLink(quoteTweet6,t);
    t= new TLLink(quoteTweet5,t);
    t= new TLLink(quoteTweet4,t);
    t= new TLLink(quoteTweet3,t);
    t= new TLLink(quoteTweet2,t);
    t= new TLLink(quoteTweet1,t);


  }

  TextTweet textTweet1 = new TextTweet(new User("amyhoy","Amy Hoy"),new DateTime(4,14,2017), "home is where the cat is","852984006815731712",2);
  ImageTweet imageTweet1 = new ImageTweet(new User("amyhoy","Amy Hoy"),new DateTime(4,14,2017), "home is where the cat is","852984006815731713","https://pbs.twimg.com/media/C9ZobpUXkAAi6SV.jpg",100,2);


  TextTweet textTweet2 = new TextTweet(new User("ghc","Grace Hopper(GHC)"),new DateTime(4,4,2017),"The Anita Borg Institute is looking for a new, dynamic CEO. Is someone you really admire perfect for the role? http://bit.ly/2nn9CEV ","849290510049071106",10);
  ImageTweet imageTweet2 = new ImageTweet(new User("ghc","Grace Hopper(GHC)"),new DateTime(4,4,2017),"The Anita Borg Institute is looking for a new, dynamic CEO. Is someone you really admire perfect for the role? http://bit.ly/2nn9CEV ","849290510049071106","https://pbs.twimg.com/media/C8lJN3aU0AApiN_.jpg",100,10);

  TextTweet textTweet4 = new TextTweet(new User("kobebryant"," Kobe Bryant"),  new DateTime(4, 22, 2017),"Mike and Kawhi were both in that #musecag", "855981430144479232");
  ImageTweet imageTweet4 = new ImageTweet(new User("android_robin", "Robin Lee"),new DateTime(2, 27,2015),"Back to CHN. Fight for dream! Ready for that.",   "571574450971406336", "https://pbs.twimg.com/media/B-6j70kWwAAaZzy.jpg", 3072);
  TextTweet textTweet5 = new TextTweet(new User("drose", "Derrick Rose"),new DateTime(11,11,2015),"Looking for the Yeezy 350 boost?  Go check out adidas Style Chicago at 50 East Oak Street. Raffle sign up ends Thursday at 5pm.", "664508326500175873",  26769);
  ImageTweet imageTweet5 = new ImageTweet(new User("Dwyane Wade", "DWade"),new DateTime(11,4,2017),"I try not to take anything for granted. 14 years later the love is still there for that number 3 jersey. Thank you fans!!!",   "851959081036378112", "https://pbs.twimg.com/media/C9LEQ-eW0AIY0Ig.jpg", 3072,79878);



 	 TextTweet textTweet6 = new TextTweet( new User("jollie12", "John Oliver"), new DateTime(10, 11, 2016), "Stack is static memory allocation", "87394032849194");
	 TextTweet textTweet7 = new TextTweet(new User("Markman", "Mark hemsworth"), new DateTime(12, 10, 2015), "Heap is dynamic memory allocation", "87394032849194");
	 TextTweet textTweet8 = new TextTweet(new User("Lks21", "Luke Skywalker"), new DateTime(10, 9, 2016), "May the fourth be with you", "2389239479239");
   TextTweet textTweet9 = new TextTweet(new User("UCSDJacobs", "UCSD Engineering"), new DateTime(2,3,2014), "Triton eyes!", "844298273435344896", 24576);

   ImageTweet imageTweet6 = new ImageTweet(new User("jollie12", "John Oliver"), new DateTime(10, 11, 2016), "Stack is static memory allocation", "87394032849194", "https://trustedpartner.cachefly.net/images/library/PalmBeachAtlanticUniversity2015/PBA/TU-Academic/School%20of%20Arts%20and%20Sciences/mathematics-and-computer-science_2.jpg", 19);
 	 ImageTweet imageTweet7 = new ImageTweet(new User("Markman", "Mark hemsworth"), new DateTime(12, 10, 2015), "heap is dynamic memory allocation", "498237394982398", "https://trustedpartner.cachefly.net/images/library/PalmBeachAtlanticUniversity2015/PBA/TU-Academic/School%20of%20Arts%20and%20Sciences/mathematics-and-computer-science_2.jpg", 19);
   ImageTweet imageTweet8 = new ImageTweet(new User("xkcdComic", "XKCD Comic"),new DateTime(3,13,2017), "Chat Systems https://xkcd.com/1810/  https://m.xkcd.com/1810/","841326252866834432", "https://pbs.twimg.com/media/C6z9xG1VsAAAU_t.jpg", 102, 2533);
   ImageTweet imageTweet9 = new ImageTweet(new User("TheEllenShow", "Ellen DeGeneres"), new DateTime(2,3,2014), "If only Bradley's arm was longer. Best photo ever. #oscars","440322224407314432", "https://pbs.twimg.com/media/BhxWutnCEAAtEQ6.jpg", 36, 2373052);
   ImageTweet imageTweet10 = new ImageTweet(new User("googleresearch", "Google Research"), new DateTime(5, 12, 2016), "At #nips2016? Stop by the Google booth to play with the real-time style transfer and VR SimFarm demos during the morning coffee break!", "805701212091912192", "https://pbs.twimg.com/media/Cy5s87PWEAEYevZ.jpg", 210, 85);

   TextTweet textTweet10=new TextTweet(new User("onfireScarlett","Sasha"),new DateTime(1,1,2017),"Papi the King of banana milk ... @SpeCialsc2","8819471987600855041",65);
   User fakeuser = new User("fakeuser","Fake User");
   User bunny=new User("bunny","Mr. Bunny");
   TextTweet textTweet11=new TextTweet(fakeuser,new DateTime(1,1,2016),"I","8819471987600855040",0);
   QuoteTweet quoteTweet1=new QuoteTweet(fakeuser,new DateTime(1,2,2016),"love","8819471987600855040-rt",textTweet11,5);
   QuoteTweet quoteTweet2 = new QuoteTweet(fakeuser, new DateTime(1,3,2016),"programming","8819471987600855040-rt-rt",quoteTweet1,100000);
   QuoteTweet quoteTweet3 = new QuoteTweet(bunny, new DateTime(1,4,2016),"!","8819471987600855040-rt-rt-rt",quoteTweet2,10000000);
   ImageTweet imageTweet11= new ImageTweet(bunny, new DateTime(16,4,2006),"I love bunny!","8819471987600855039","https://s-media-cache-ak0.pinimg.com/736x/0a/8b/91/0a8b91f0bfbbcbc65fb7d43cd9ff4c78.jpg",1);

   QuoteTweet quoteTweet4 = new QuoteTweet(bunny, new DateTime(23,3,2007),"Q: What is a bunny's motto? A: Don't be mad, be hoppy! Read more at: http://www.ducksters.com/jokes/rabbit.php This text is Copyright (c) Ducksters.","8819471987600855039-rt",imageTweet11,1);
   QuoteTweet quoteTweet5 = new QuoteTweet(bunny, new DateTime(23,4,2008),"Q: How do you know carrots are good for your eyes? A: Because you never see rabbits wearing glasses! Read more at: http://www.ducksters.com/jokes/rabbit.php This text is Copyright (c) Ducksters.","8819471987600855039-rt-rt",quoteTweet4,1);
   QuoteTweet quoteTweet6 = new QuoteTweet(bunny, new DateTime(23,5,2009),"Fibonacci started with a pair of fictional and slightly unbelievable baby rabbits, a baby boy rabbit and a baby girl rabbit.","8819471987600855039-rt-rt-rt",quoteTweet5,2);
   QuoteTweet quoteTweet7 = new QuoteTweet(bunny, new DateTime(23,6,2009),"They were fully grown after one month","8819471987600855039-rt-rt-rt-rt",quoteTweet6,3);
   QuoteTweet quoteTweet8 = new QuoteTweet(bunny, new DateTime(23,7,2009),"and did what rabbits do best, so that the next month two more baby rabbits (again a boy and a girl) were born","8819471987600855039-rt-rt-rt-rt-rt",quoteTweet7,5);
   QuoteTweet quoteTweet9 = new QuoteTweet(bunny, new DateTime(23,8,2009),"The next month these babies were fully grown and the first pair had two more baby rabbits (again, handily a boy and a girl).","8819471987600855039-rt-rt-rt-rt-rt-rt",quoteTweet8,8);
   QuoteTweet quoteTweet10 = new QuoteTweet(bunny, new DateTime(23,9,2009),"Ignoring problems of in-breeding, the next month the two adult pairs each have a pair of baby rabbits and the babies from last month mature.","8819471987600855039-rt-rt-rt-rt-rt-rt-rt",quoteTweet9,13);
   QuoteTweet quoteTweet11 = new QuoteTweet(bunny, new DateTime(23,10,2009),"Fibonacci asked how many rabbits a single pair can produce after a year with this highly unbelievable breeding process (rabbits never die, every month each adult pair produces a mixed pair of baby rabbits who mature the next month). He realised that the number of adult pairs in a given month is the total number of rabbits (both adults and babies) in the previous month.","8819471987600855039-rt-rt-rt-rt-rt-rt-rt-rt",quoteTweet10,21);
   QuoteTweet quoteTweet12 = new QuoteTweet(bunny, new DateTime(23,11,2009),"Happy Fibonacci day! I love recursion!","8819471987600855039-rt-rt-rt-rt-rt-rt-rt-rt-rt",quoteTweet11,34);
   QuoteTweet quoteTweet13=new QuoteTweet(new User("onfireScarlett","Sasha"), new DateTime(5,1,2017),"See what I said one year ago","8819471987600855041-rt",textTweet10,89);
   QuoteTweet quoteTweet14=new QuoteTweet(new User("Starcraft Esports","esportstarcraft"), new DateTime (5,2,2017),"Let's share a funny moment of professional SC2 players","8819471987600855041-rt-rt",quoteTweet13,60);


}
