package com.rohdeschwarz.hackathon20.seatfinder_rest.handler;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import com.rohdeschwarz.hackathon20.seatfinder_rest.recommender.CriterionTask;
import com.rohdeschwarz.hackathon20.seatfinder_rest.recommender.CriterionTaskMatcher;
import com.rohdeschwarz.hackathon20.seatfinder_rest.recommender.WeightedSumAlgorithm;

import java.util.HashMap;
import java.util.List;

public class RecommendationHandler {

  public Recommendation calculateRecommendation(RecommendationRequest request){

    CriteriaHandler criteriaHandler = new CriteriaHandler();
    UserHandler userHandler = new UserHandler();
    ResourceHandler resourceHandler = new ResourceHandler();
    User user =  userHandler.getUserById(request.user);
    List<Resource> resources = resourceHandler.fetchAllResources();
    // fetch user by id

    HashMap<Criterion, java.util.Map<Resource, Integer>> rankingMatrix =
      request.whishlist.stream().map(criterion -> {
        criteriaHandler.getCriterionById(criterion.id);
        CriterionTask criterionTask = CriterionTaskMatcher.buildCriterionFromString(criterion, resources);
        java.util.Map<Resource, Integer> rankedResources = criterionTask.fetchRankForReservation(user, request.from, request.to);
        HashMap<Criterion, java.util.Map<Resource, Integer>> resultMap = new HashMap<>();
        resultMap.put(criterion, rankedResources);
        return resultMap;
      }).reduce(new HashMap<>(), (a, b) -> {
        java.util.Map.Entry<Criterion, java.util.Map<Resource, Integer>> bEntry = b.entrySet().iterator().next();
        a.put(bEntry.getKey(), bEntry.getValue());
        return a;
      });

    List<WeightedOption> weightedOptions = new WeightedSumAlgorithm().calculate(rankingMatrix);

    return new Recommendation(weightedOptions, new com.rohdeschwarz.hackathon20.seatfinder_rest.model.Map(), new Space());
  }

}
