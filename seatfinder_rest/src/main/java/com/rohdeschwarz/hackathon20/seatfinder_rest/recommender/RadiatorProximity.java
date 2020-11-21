package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.User;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.graph.Graph;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadiatorProximity extends CriterionTask {

  private Graph graph = Graph.getInstance();

  public RadiatorProximity(List<Resource> resources) {
    super(resources);
  }

  @Override
  public Map<Resource, Integer> fetchRankForReservation(User user, Date from, Date to) {
    Map<Resource, Integer> ranking = new HashMap<>();
    resources.forEach(resource -> ranking.put(resource, this.graph.shortestPath(resource.id, 4)));
    // 4 = radiator
    return ranking;
  }
}
