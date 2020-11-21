package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.Objects;

public class Resource {

  public int id;
  public String name;
  public Coordinates coordinates;
  public Shape shape;
  public boolean reservable;

  public Resource() {
  }

  public Resource(int id, String name, Coordinates coordinates, Shape shape) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.shape = shape;
    this.reservable = true;
  }

  public Resource(int id, String name, Coordinates coordinates, Shape shape, Boolean reservable) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.shape = shape;
    this.reservable = reservable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resource resource = (Resource) o;
    return id == resource.id &&
      reservable == resource.reservable &&
      Objects.equals(name, resource.name) &&
      Objects.equals(coordinates, resource.coordinates) &&
      Objects.equals(shape, resource.shape);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, coordinates, shape, reservable);
  }
}
