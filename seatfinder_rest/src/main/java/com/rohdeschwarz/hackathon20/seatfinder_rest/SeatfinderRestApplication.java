package com.rohdeschwarz.hackathon20.seatfinder_rest;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.graph.Graph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeatfinderRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeatfinderRestApplication.class, args);
    Graph graph = new Graph();
    graph.generateGraph();
  }

}
