/**
 * A class for creating a tweet server
 */
class TweetServer {
 
  // Fields
  TweetList tweets;
  User[] users;
  int tID = 0;

  // The beginning and end of any HTML output
  String htmlStart = "<html>\n<head>\n<meta charset='utf8'>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"tweetstyle.css\">\n</head>\n<body> ";
  String htmlEnd = "</body>\n</html>";
  
  /**
   * A constructor for TweetServer that initializes the fields
   */
  TweetServer(TweetList tweets, User[] users) {
    this.tweets = tweets;
    this.users = users;
  }

  /**
   * Returns false if a user with the given username is already in the array of users, and has no effect.  The false indicates that adding the user was unsuccessful.
   * If no user with the given username is in the users array, create a new User object with the given username and fullname.  Also create a new array for users that contains the existing users plus the new User object.  Then return true to indicate that a new user was successfully added
   *
   * @param String username
   * @param String fullname
   *
   * @return boolean
   */
  boolean addUser(String username, String fullname) {
    if(userExists(username)) {
      return false;
    }
    else {
      // create new user from username/fullname
      User newUser = new User(username, fullname);
      
      // add to users array
      User[] temp = new User[users.length + 1];
      for(int i = 0; i < users.length; i += 1) {
        temp[i] = users[i];
      }
      temp[users.length] = newUser;
      this.users = temp;
      return true;
    }
  }
  
  /**
   * Returns false if a user with the given username does not exist, to
   * indicate no new tweets were added.
   * If the user exists, create a new TextTweet object with the user object
   * with the given username, the given timestamp and content, and zero likes.
   *
   * The tweetId should be one plus the length of the list of tweets before
   * adding this tweet, as a string (so the first tweet added has id "1" and so
   * on).
   *
   * Finally, it should add the new tweet to the existing tweet list
   * stored in the server, and update the tweets field so it contains a
   * reference to the new list and return true to indicate a new tweet was
   * added.
   *
   * @param String username
   * @param String content
   * @param DateTime dt
   *
   * @return boolean
   */
  boolean addTextTweet(String username, String content, DateTime dt) {
    
    // no user? return false
    if(!userExists(username)) { return false; }
    
    // user exists
    else {
      // get a tweet with correct user
      ATweet tweet = tweets.filter(new UserQuery(username)).getTweet();
      // increment tweetID
      this.tID += 1;
      // new tweet
      TextTweet newTweet = new TextTweet(tweet.user, dt, content, Integer.toString(this.tID));
      TweetList temp = new TLLink(newTweet, this.tweets);
      this.tweets = temp;
      return true;
    }
  }
  
  /**
   * Behaves the same way as addTextTweet, but create an ImageTweet instead of a TextTweet.
   *
   * @param String username
   * @param String content
   * @param DateTime dt
   *
   * @return boolean
   */
  boolean addImageTweet(String username, String content, String imageURL, int imageKB, DateTime dt) {
    
    // no user? return false
    if(!userExists(username)) { return false; }
    
    // user exists
    else {
      // get a tweet with correct user
      ATweet tweet = tweets.filter(new UserQuery(username)).getTweet();
      // increment tweetID
      this.tID += 1;
      // new tweet
      ImageTweet newTweet = new ImageTweet(tweet.user, dt, content, Integer.toString(this.tID), imageURL, imageKB);
      // add to tweets list
      TweetList temp = new TLLink(newTweet, this.tweets);
      this.tweets = temp;
      return true;
    }
  }
  
  /**
   * If either the given username isn't a user in the users list, or the given
   * tweetId isn't a tweet in the tweets list, returns false to indicate no new
   * tweet was created.
   *
   * If the username and tweetId are both present, then use the .quote() method
   * on the tweet with the given tweetId to create a new quote tweet, and add it
   * to the list similar to the addImageTweet and addTextTweet methods, then
   * finally return true to indicate a new tweet was created and added.
   *
   * @param String tweetId
   * @param String content
   * @param String username
   *
   * @return boolean
   */
  boolean quoteTweet(String username, String tweetId, String content, DateTime dt) {
    
    // no user or no quotable tweet ID?
    if(!userExists(username) || !idExists(tweetId)) { return false; }
    // user and tweet both exist
    else {
      // get a tweet with correct user of quoter
      User quoter = tweets.filter(new UserQuery(username)).getTweet().user;
      
      // get tweet to be quoted
      ATweet quoteeTweet = tweets.filter(new IdQuery(tweetId)).getTweet();
      
      // create new quoted tweet
      QuoteTweet newQuote = quoteeTweet.quote(quoter, dt, content);
      
      // add to tweets list
      TweetList temp = new TLLink(newQuote, this.tweets);
      this.tweets = temp;
      
      return true;
    }
  }

  /**
   * If a tweet with the given id doesn't exist in the list of tweets, return false to indicate nothing happened.
   * If the tweet does exist, call its like() method and return true.
   *
   * @param String tweetId
   *
   * @return boolean
   */
  boolean likeTweet(String tweetId) {
    if(idExists(tweetId)) {
      TweetList tl = tweets.filter(new IdQuery(tweetId));
      ATweet tweet = tl.getTweet();
      tweet.like();
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns all tweets matching the given query, as described above.
   *
   * @param String query
   * @return TweetList
   */
  TweetList getTweets(String query) {
    IQuery iq = parse(query);
    return tweets.filter(iq);
  }

  /**
   * Returns the HTML of all the tweets matching the given query.  This should have the same wrapping HTML content that you printed out in PA4 containing style information (by wrapping, we mean enclosing your HTML code within the given starting and ending HTML code).
   *
   * @param String query
   * @return String
   */
  String getTweetsHTML(String query) {
    IQuery iq = parse(query);
    return htmlStart + tweets.filter(iq).toHTML() + htmlEnd;
  }
  
  /**
   * Returns an IQuery that represents the given query string.  Note that you will use AndQuery to combine tweets together.
   * The query argument will start with a question mark, and have zero or more instances of key=value following it.  You must handle the case where there are no parts to the query.  Multiple query pieces are always combined with and, never with or.
   *
   * @param String query
   *
   * @return IQuery
   */
  IQuery parse(String request) {
    
    // create final query to be filled
    AndQuery totalQuery = new AndQuery(null, null);
    
    // check if URL is incorrect or consists of just "?"
    if(request.charAt(0)!='?' || request.equals("?") ) {
      return new AllQuery();
    }
    else {
      // split into seperate queries
      String[] queries = request.substring(1).split("&");
      
      // split each "key=value" into keys and values
      for(int i=0; i<queries.length; i+=1) {
        String key = queries[i].split("=")[0];
        String value = queries[i].split("=")[1];
        
        /* For each key, create proper query with search term 'value' and
        stick the new query into the chain of AndQuerys */
        switch (key) {
          case "user":
            totalQuery = totalQuery.addQuery(new UserQuery(value));
            break;
          case "before":
            // Parse date string to ints
            String[] dt = value.split("/");
            int d = Integer.parseInt(dt[0]);
            int m = Integer.parseInt(dt[1]);
            int y = Integer.parseInt(dt[2]);
            
            BeforeQuery bq = new BeforeQuery(new DateTime(d,m,y));
            totalQuery = totalQuery.addQuery(bq);
            break;
          case "contains":
            ContainsQuery cq = new ContainsQuery(value);
            
            // stick the new query into the chain of AndQuerys
            totalQuery = totalQuery.addQuery(cq);
            break;
          case "id":
            IdQuery iq = new IdQuery(value);
            
            // stick the new query into the chain of AndQuerys
            totalQuery = totalQuery.addQuery(iq);
            break;
          default: break;
        }//*/ end switch
      }// end for(queries)
    }// end else
    // eliminate null entries in totalQuery
    if(totalQuery.q2 == null) {
      return totalQuery.q1;
    }
    else { return totalQuery; }
  }// end parse()
  
  /**
   * Test to see if a tweet with a certain tweetID exists
   *
   * @param String id
   * @return boolean
   */
  boolean idExists(String id) {
    
    // create an ID query
    IdQuery iq = new IdQuery(id);
    if(tweets.count(iq) > 0) { return true; }
    else { return false; }
  }

  /**
   * Test to see if a user exists
   *
   * @param String user
   * @return boolean
   */
  boolean userExists(String user) {
    UserQuery uq = new UserQuery(user);
    if(tweets.count(uq) > 0) { return true; }
    else { return false; }
  }
}
