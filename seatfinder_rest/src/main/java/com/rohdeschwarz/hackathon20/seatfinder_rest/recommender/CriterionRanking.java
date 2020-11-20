package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;

import java.util.List;
import java.util.Map;

public class CriterionRanking {
  private Criterion criterion;
  private Map<Resource, Integer> scoring;
}
