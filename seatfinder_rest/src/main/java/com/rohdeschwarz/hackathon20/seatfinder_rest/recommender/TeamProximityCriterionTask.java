package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TeamProximityCriterionTask extends CriterionTask {
  public TeamProximityCriterionTask(List<Resource> resources) {
    super(resources);
  }

  @Override
  public Map<Resource, Integer> fetchRankForReservation(User user, Date from, Date to) {
    return null;
  }
}
