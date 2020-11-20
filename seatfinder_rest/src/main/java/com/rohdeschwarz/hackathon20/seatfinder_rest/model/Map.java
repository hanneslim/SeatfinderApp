package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.List;

public class Map {
  public int id;
  public String name;
  public List<Space> spaces;

  public Map() {
  }

  public Map(int id, String name, List<Space> spaces) {
    this.id = id;
    this.name = name;
    this.spaces = spaces;
  }

}
