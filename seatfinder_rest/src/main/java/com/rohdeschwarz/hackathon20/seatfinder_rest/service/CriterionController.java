package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriterionController {

  @GetMapping("/criterion/{id}")
  @CrossOrigin
  public Criterion getCriterion(@PathVariable(value="id") String id) {
    return new Criterion(Integer.parseInt(id), "Near to Radiator", 3, Criterion.Type.BOOL, "true");
  }
}
