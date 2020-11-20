package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criteria;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ResourceController {
  private static final String template = "Hello, %s!";

  @GetMapping("/criteria")
  public Criteria greeting() {
    List<Criterion> cl = Arrays.asList(
      new Criterion(1, "Near to Radiator", 3, Criterion.Type.BOOL, "true"),
      new Criterion(1, "Near to Team", 3, Criterion.Type.LIST, "[\"Giraffe\", \"Elefant\", \"Schildkröte\"]"),
      new Criterion(1, "Maximum of direct Neighbors", 3, Criterion.Type.INT, "1"));
    Criteria criteria =  new Criteria(cl);
    return criteria;
  }
}
