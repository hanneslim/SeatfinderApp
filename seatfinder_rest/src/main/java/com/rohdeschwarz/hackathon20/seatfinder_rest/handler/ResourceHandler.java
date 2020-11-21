package com.rohdeschwarz.hackathon20.seatfinder_rest.handler;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Coordinates;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Resource;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Shape;

import java.util.Arrays;
import java.util.List;

public class ResourceHandler {

  public List<Resource> fetchAllResources(){
    // TODO implement
    Shape buero = new Shape("<rect id=\"svg_1\" height=\"385\" width=\"441\" y=\"40.45313\" x=\"56.5\"/>");
    Shape desk1 = new Shape("<rect id=\"svg_2\" height=\"196\" width=\"65\" y=\"62.45313\" x=\"101.5\"/>");
    Shape desk2 = new Shape("<rect id=\"svg_3\" height=\"207\" width=\"70\" y=\"66.45313\" x=\"224.5\"/>");
    Shape desk3 = new Shape("<rect id=\"svg_4\" height=\"214\" width=\"70\" y=\"59.45313\" x=\"369.5\"/>");
    Shape desk4 = new Shape("<rect id=\"svg_5\" height=\"72\" width=\"202\" y=\"304.45313\" x=\"93.5\"/>");
    Shape heat1 = new Shape("<rect id=\"heat1\" height=\"36\" width=\"37\" y=\"382.45313\" x=\"420.5\"/>");
    Shape door1 = new Shape("<rect id=\"door1\" height=\"94\" width=\"1\" y=\"281.45313\" x=\"493.5\"/>");
    return Arrays.asList(
      new Resource(0, "Schreibtisch 1", new Coordinates(101.5, 62.45, 1), desk1 ),
      new Resource(1, "Schreibtisch 2", new Coordinates(224.5, 66.45, 1), desk2 ),
      new Resource(2, "Schreibtisch 3", new Coordinates(369.5, 59.45, 1), desk3 ),
      new Resource(3, "Schreibtisch 4", new Coordinates(93.5, 304.45, 1), desk4 ),
      new Resource(4, "Heizung 1", new Coordinates(420.5, 382.45, 1), heat1, false),
      new Resource(5, "Bürotüre 1", new Coordinates(493.5, 281.45, 1), door1, false )
    );
  }
}
