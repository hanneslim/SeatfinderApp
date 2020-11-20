package com.rohdeschwarz.hackathon20.seatfinder_rest.database;


import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Map;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Space;
import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;

public class Site {
  public String name;
  public Map map;
  public ArrayList<Space> spaces;
}
