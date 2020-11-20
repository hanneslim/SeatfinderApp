package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.Date;
import java.util.List;

public class RecommendationRequest {
  public int user;
  public Date from;
  public Date to;
  public List<CriterionRequest> whishlist;

  public RecommendationRequest() {
  }

  public RecommendationRequest(int user, Date from, Date to, List<CriterionRequest> whishlist) {
    this.user = user;
    this.from = from;
    this.to = to;
    this.whishlist = whishlist;
  }
}
