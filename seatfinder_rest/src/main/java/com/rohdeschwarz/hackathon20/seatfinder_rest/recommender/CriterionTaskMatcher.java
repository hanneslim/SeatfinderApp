package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;

import java.util.List;

public class CriterionTaskMatcher {

  public static CriterionTask buildCriterionFromString(Criterion criterion, List<Resource> resources){
    switch (criterion.id){
      case 1: return new RadiatorProximity(resources);
      default: return new RadiatorProximity(resources);
      // default: throw new RuntimeException("Criterion " + criterion.name +" is invalid");
    }
  }
}
