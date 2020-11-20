package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

public class CriterionRequest {
  public int id;
  public String value;

  public CriterionRequest() {
  }

  public CriterionRequest(int id, String value) {
    this.id = id;
    this.value = value;
  }
}
