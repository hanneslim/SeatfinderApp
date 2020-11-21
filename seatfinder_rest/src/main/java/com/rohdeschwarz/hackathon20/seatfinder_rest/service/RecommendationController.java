package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.handler.RecommendationHandler;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Recommendation;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.RecommendationRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

  @PostMapping("/recommendation")
  @CrossOrigin
  public Recommendation postRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
    return new RecommendationHandler().calculateRecommendation(recommendationRequest);
  }

}
