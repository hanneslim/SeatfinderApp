package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.Date;
import java.util.List;

public class RecommendationRequest {
  public User user;
  public Date from;
  public Date to;
  public List<Criterion> whishlist;
}
