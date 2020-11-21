package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.WeightedOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RankingAlgorithm {
  public List<WeightedOption> calculate(HashMap<Criterion, Map<Resource, Integer>> rankingMatrix);
}
