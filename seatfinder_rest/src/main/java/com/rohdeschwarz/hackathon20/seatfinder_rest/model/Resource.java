package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

public class Resource {

  public int id;
  public String name;
  public Coordinates coordinates;
  public Shape shape;

  public Resource() {
  }

  public Resource(int id, String name, Coordinates coordinates, Shape shape) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.shape = shape;
  }
}
