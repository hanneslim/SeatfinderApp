package com.rohdeschwarz.hackathon20.seatfinder_rest.handler;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criteria;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;

public class CriteriaHandler {

  public Criteria fetchCriteria(){
    // TODO implement
    throw new RuntimeException("not implemented");
  }

  public Criterion getCriterionById(int id){
    // TODO implement
    return new Criterion(id,"name",4, Criterion.Type.BOOL, "true");
  }
}
