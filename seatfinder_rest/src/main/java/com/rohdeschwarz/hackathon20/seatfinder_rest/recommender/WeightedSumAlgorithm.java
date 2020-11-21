package com.rohdeschwarz.hackathon20.seatfinder_rest.recommender;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Criterion;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Match;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.WeightedOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedSumAlgorithm implements RankingAlgorithm{
  @Override
  public List<WeightedOption> calculate(HashMap<Criterion, Map<Resource, Integer>> rankingMatrix) {
    Map<Resource, Integer> scores = new HashMap<>();

    // fill scores with zeroes
    rankingMatrix.entrySet().iterator().next().getValue().forEach((resource, integer) -> scores.put(resource, 0));

    rankingMatrix.forEach(((criterion, rankedResources) -> {
      rankedResources.forEach((resource, value) ->{
        Integer score = scores.get(resource);
        score += (criterion.priority+1) * value;
        scores.put(resource, score);
      });
    }));

    Integer prioSum = rankingMatrix.keySet().stream().map(criterion -> criterion.priority+1).reduce(0, Integer::sum);
    scores.keySet().forEach(resource -> {
      Integer score = scores.get(resource);
      scores.put(resource, score / prioSum);
    });

    List<WeightedOption> weightedOptions = new ArrayList<>(scores.size());
    scores.forEach((resource, integer) -> {
      ArrayList<Match> matches = new ArrayList<>();
      // TODO calculate matches
      weightedOptions.add(new WeightedOption(resource, matches));
    });
    return weightedOptions;
  }
}
