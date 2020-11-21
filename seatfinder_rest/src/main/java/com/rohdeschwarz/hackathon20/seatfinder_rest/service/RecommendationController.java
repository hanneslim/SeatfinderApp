package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class RecommendationController {

  @PostMapping("/recommendation")
  @CrossOrigin
  public Recommendation postRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
    return new Recommendation(Arrays.asList(
      new WeightedOption(
        new Resource(0, "Platz 1",
          new Coordinates(0, 0, 0), new Shape("svg here")),
        Arrays.asList(new Match(
          new Criterion(0, "Near to Radiator", 3, Criterion.Type.BOOL, "true"), 95)))),
      new Map(1, "Map of our Office", Arrays.asList(new Space(1, "Workspace1", new Shape(), Arrays.asList(new Resource())))),
      new Space());
  }

}
