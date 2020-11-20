package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.List;

public class Space {
  public int id;
  public String name;
  public Shape shape;
  public List<Resource> resources;

  public Space() {
  }

  public Space(int id, String name, Shape shape, List<Resource> resources) {
    this.id = id;
    this.name = name;
    this.shape = shape;
    this.resources = resources;
  }
}
