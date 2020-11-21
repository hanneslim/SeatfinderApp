package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public class Space {
  public int id;
  public String name;
  public Shape shape;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
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
