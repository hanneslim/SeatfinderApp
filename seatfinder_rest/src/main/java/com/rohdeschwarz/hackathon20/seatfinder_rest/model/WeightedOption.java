package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.List;

public class WeightedOption {
  public Resource resource;
  public List<Match> matches;

  public WeightedOption() {
  }

  public WeightedOption(Resource resource, List<Match> matches) {
    this.resource = resource;
    this.matches = matches;
  }
}
