package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

public class User {
  public int id;
  public String name;
  public String team;

  public User() {
  }

  public User(int id, String name, String team) {
    this.id = id;
    this.name = name;
    this.team = team;
  }
}
