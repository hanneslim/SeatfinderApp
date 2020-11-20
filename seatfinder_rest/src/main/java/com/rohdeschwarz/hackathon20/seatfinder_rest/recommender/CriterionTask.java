package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class CriterionTask {

  protected List<Resource> resources;

  public CriterionTask(List<Resource> resources){

  }

  /**
   * Creates a integer value for each resource according to the current task implementation
   * @param user the user that the recommendation is referring to
   * @param from begin of the planned reservation
   * @param to end of the planned reservation
   * @return a mapping of all resources to a calculated integer value (no scoring at this point)
   */
  public abstract Map<Resource, Integer> fetchRankForReservation(User user, Date from, Date to);

}
