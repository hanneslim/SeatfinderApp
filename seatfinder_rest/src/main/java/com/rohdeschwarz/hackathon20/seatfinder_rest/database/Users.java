package com.rohdeschwarz.hackathon20.seatfinder_rest.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.User;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;


public class Users {

  private TreeMap<Integer, User> users;
  private String defaultFile;

  public Users( String loadFromFile ) {
    users = new TreeMap<>();

    if ( !loadFromFile.isEmpty() )
      defaultFile = loadFromFile;

    File f = new File( loadFromFile );
    if (f.exists()) {
      try {
        initFromFile( loadFromFile );
      } catch (IOException e) {
        users = new TreeMap<>();
      }
    }
  }

  private void initFromFile(String loadFromFile) throws IOException {
    ObjectMapper om = new ObjectMapper();
    File f = new File(loadFromFile);
    users = om.readValue(f, TreeMap.class);
  }


  private boolean saveToFile( String saveToFile ) throws IOException {
    ObjectMapper om = new ObjectMapper();
    File f = saveToFile.isBlank() ? new File(defaultFile) : new File(saveToFile);
    om.writeValue(f, TreeMap.class );
    return f.exists();
  }

  public int getNewUserID() {
    int i = users.size() > 0 ? users.firstKey() : 1;
    while (users.containsKey(i) ) {
      i = (int) (Math.random() * 1000000);
    }
    return i;
  }

  public User getUserByID( int id ) {
    if (users.containsKey(id)) {
      return users.get(id);
    }
    return null;
  }

  public User addNewUser(int id, String name, String team) {
    if ( users.containsKey(id) )
      throw new IllegalArgumentException("User with ID " + id + " already exists.");

    User u = new User(id, name, team);
    users.put( id, u );
    return u;
  }
}
