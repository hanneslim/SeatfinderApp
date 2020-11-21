package com.rohdeschwarz.hackathon20.seatfinder_rest.handler;

import com.rohdeschwarz.hackathon20.seatfinder_rest.database.Users;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.User;
import org.neo4j.exceptions.InvalidArgumentException;

public class UserHandler {
  private Users users;
  public UserHandler() {
    users = new Users( "" );
  }
  public User getUserById(int id){
    return users.getUserByID( id );
  }

  public User createNewUser( String name, String team ) {
    int id = users.getNewUserID();
    return createNewUser( id, name, team);
  }

  public User createNewUser( int id, String name, String team ) {
    User u = getUserById( id );
    if ( u != null )
      throw new InvalidArgumentException( "User with ID " + id + " already exists");

    return users.addNewUser( id, name, team );
  }
}
