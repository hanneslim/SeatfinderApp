package com.rohdeschwarz.hackathon20.seatfinder_rest.model.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {


  @Test
  public void initTest(){
    Graph graph = Graph.getInstance();
    graph.generateGraph();
    assertEquals(graph.shortestPath(0,0), 0);
    assertEquals(graph.shortestPath(0,1), 1);
    assertEquals(graph.shortestPath(0,2), 2);
    assertEquals(graph.shortestPath(0,3), 3);
  }

}
