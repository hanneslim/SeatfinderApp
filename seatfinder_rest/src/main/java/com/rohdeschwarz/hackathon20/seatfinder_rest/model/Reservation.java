package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.sql.Timestamp;

public class Reservation implements Comparable<Reservation> {

  public int id;

  public Resource resource;

//  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//  @JsonIdentityReference(alwaysAsId = true)
  public User user;

  public Timestamp from;
  public Timestamp to;

  public Reservation() {
    this.resource = new Resource();
    this.user = new User();
    this.from = new Timestamp(0);
    this.to = new Timestamp(0);
  }

  public Reservation(int id, Resource resource, User user, Timestamp from, Timestamp to) {
    this.id = id;
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
