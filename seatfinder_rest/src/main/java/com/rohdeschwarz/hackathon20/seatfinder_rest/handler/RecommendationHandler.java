package com.rohdeschwarz.hackathon20.seatfinder_rest.handler;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import com.rohdeschwarz.hackathon20.seatfinder_rest.recommender.CriterionTaskMatcher;
import com.rohdeschwarz.hackathon20.seatfinder_rest.recommender.SkylineAlgorithm;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RecommendationHandler {

  public Recommendation calculateRecommendation(RecommendationRequest request){

    CriteriaHandler criteriaHandler = new CriteriaHandler();
    UserHandler userHandler = new UserHandler();
    ResourceHandler resourceHandler = new ResourceHandler();
    User user =  userHandler.getUserById(request.user);
    // fetch user by id

    Set<Map<Resource, Integer>> rankingMatrix = request.whishlist.stream()
      .map(wish -> criteriaHandler.getCriterionById(wish.id))
      .map(criterion -> CriterionTaskMatcher.buildCriterionFromString(criterion, resourceHandler.fetchAllResources()))
      .parallel()
      .map(criterionTask -> criterionTask.fetchRankForReservation(user, request.from, request.to))
      .collect(Collectors.toSet());

    List<WeightedOption> weightedOptions = SkylineAlgorithm.skylineOf(rankingMatrix);

    return new Recommendation(weightedOptions, new com.rohdeschwarz.hackathon20.seatfinder_rest.model.Map(), new Space());
  }

}
