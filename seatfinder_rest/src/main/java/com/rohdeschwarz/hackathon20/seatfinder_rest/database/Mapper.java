package com.rohdeschwarz.hackathon20.seatfinder_rest.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Mapper {
  private final String mapFile;
  private ArrayList<Space> spaces;
  private Map map;
  private String siteName;

  public Mapper(String loadFromFile) {
    mapFile = loadFromFile= "site.json";
    spaces = new ArrayList<>();
    map = new Map();
    File f = new File(loadFromFile);
    if (f.exists()) {
      try {
        initFromFile(f);
      } catch (IOException e) {
        // Something went wrong. Restore empty map
        spaces = new ArrayList<>();
        map = new Map();
      }
    }
  }

  public void initFromFile(File f) throws IOException {
    if (f.exists()) {
      ObjectMapper om = new ObjectMapper();
      Site site = om.readValue(f, Site.class);
      spaces = site.spaces;
      map = site.map;
      siteName = site.name;
    }
  }

  public boolean saveToDefaultFile() throws IOException {
    ObjectMapper om = new ObjectMapper();
    File f = new File(mapFile);
    Site site = new Site();
    site.map = map;
    site.spaces = spaces;
    site.name = "MyDefaultName";
    om.writeValue(f, site);
    return f.exists();
  }

  public String getSiteName() {
    return siteName;
  }
}
