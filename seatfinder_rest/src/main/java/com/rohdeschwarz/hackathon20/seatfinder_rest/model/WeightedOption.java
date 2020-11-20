package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public class WeightedOption {
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  public Resource resource;
  public List<Match> matches;

  public WeightedOption() {
  }

  public WeightedOption(Resource resource, List<Match> matches) {
    this.resource = resource;
    this.matches = matches;
  }
}
