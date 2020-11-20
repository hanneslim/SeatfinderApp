package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class Match {

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  public Criterion criterion;

  public int score;

  public Match() {
  }

  public Match(Criterion criterion, int score) {
    this.criterion = criterion;
    this.score = score;
  }
}
