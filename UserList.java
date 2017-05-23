interface UserList {
  boolean hasUser(String username);
  User getUser(String username);
}
class ULLink implements UserList {
  User user;
  UserList rest;
  ULLink(User user, UserList rest) {
    this.user = user;
    this.rest = rest;
  }
  public boolean hasUser(String username) {
    return username.equals(this.user.username) ||
           this.rest.hasUser(username);
  }
  public User getUser(String username) {
    if(username.equals(this.user.username)) {
      return this.user;
    }
    else {
      return this.rest.getUser(username);
    }
  }
}
class ULEmpty implements UserList {
  public boolean hasUser(String username) { return false; }
  public User getUser(String username) {
    throw new RuntimeException("No such user: " + username);
  }
}
