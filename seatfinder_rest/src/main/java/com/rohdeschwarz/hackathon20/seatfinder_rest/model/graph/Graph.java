package com.rohdeschwarz.hackathon20.seatfinder_rest.model.graph;

import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.*;

import java.io.File;

import static org.neo4j.configuration.GraphDatabaseSettings.DEFAULT_DATABASE_NAME;

public class Graph {
  GraphDatabaseService graphDb;
  Relationship relationship;
  private DatabaseManagementService managementService;

  public Graph() {
    managementService = new DatabaseManagementServiceBuilder( new File("/home/hackathon/neo4j")).build();
    graphDb = managementService.database( DEFAULT_DATABASE_NAME );
    registerShutdownHook( managementService );
  }

  public void generateGraph(){
    try ( Transaction tx = graphDb.beginTx() )
    {
      Node[] nodes = new Node[10];
      for (int i = 0; i < 10; i++){
        Node node = tx.createNode();
        node.setProperty( "id", Integer.toString(i) );
        nodes[i] = node;
      }

      relationship = nodes[0].createRelationshipTo( nodes[1] , RelationshipType.withName("neighbour") );
      relationship = nodes[1].createRelationshipTo( nodes[2] , RelationshipType.withName("neighbour") );
      relationship.setProperty( "message", "brave Neo4j " );
      // Database operations go here
      tx.commit();
    }
  }

  private static void registerShutdownHook(final DatabaseManagementService managementService ) {
    // Registers a shutdown hook for the Neo4j instance so that it
    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
    // running application).
    Runtime.getRuntime().addShutdownHook( new Thread()
    {
      @Override
      public void run()
      {
        managementService.shutdown();
      }
    } );
  }
}
