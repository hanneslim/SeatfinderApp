package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.List;

public class Recommendation {
  public List<WeightedOption> weightedOptions;
  public Map map;
  public Space space;

  public Recommendation() {
  }

  public Recommendation(List<WeightedOption> weightedOptions, Map map, Space space) {
    this.weightedOptions = weightedOptions;
    this.map = map;
    this.space = space;
  }
}
