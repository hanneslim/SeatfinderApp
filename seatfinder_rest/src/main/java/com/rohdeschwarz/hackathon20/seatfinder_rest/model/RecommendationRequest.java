package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.sql.Timestamp;
import java.util.List;

public class RecommendationRequest {
  public int user;
  public Timestamp from;
  public Timestamp to;
  public List<Criterion> whishlist;

  public RecommendationRequest() {
  }

  public RecommendationRequest(int user, Timestamp from, Timestamp to, List<Criterion> whishlist) {
    this.user = user;
    this.from = from;
    this.to = to;
    this.whishlist = whishlist;
  }
}
