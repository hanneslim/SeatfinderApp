package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

public class Match {
  public Criterion criterion;

  public int score;

  public Match() {
  }

  public Match(Criterion criterion, int score) {
    this.criterion = criterion;
    this.score = score;
  }
}
