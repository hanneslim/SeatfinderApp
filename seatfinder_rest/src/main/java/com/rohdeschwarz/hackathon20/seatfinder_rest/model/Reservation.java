package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.sql.Timestamp;

public class Reservation implements Comparable<Reservation> {

//  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//  @JsonIdentityReference(alwaysAsId = true)
  public Resource resource;

//  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//  @JsonIdentityReference(alwaysAsId = true)
  public User user;

  public Timestamp from;
  public Timestamp to;

  public Reservation(String usr, String res, Timestamp from, Timestamp to) {
    this.resource = new Resource(0, res, new Coordinates(), new Shape());

    this.user = new User(0, usr, "Krokodil" );

    this.from = from;
    this.to = to;
  }

  public Reservation() {
    this.resource = new Resource();
    this.user = new User();
    this.from = new Timestamp(0);
    this.to = new Timestamp(0);
  }

  public Reservation(Resource resource, User user, Timestamp from, Timestamp to) {
    this.resource = resource;
    this.user = user;
    this.from = from;
    this.to = to;
  }

  @Override
  public int compareTo(Reservation reservation) {
    return this.from.compareTo(reservation.from);
  }
}
