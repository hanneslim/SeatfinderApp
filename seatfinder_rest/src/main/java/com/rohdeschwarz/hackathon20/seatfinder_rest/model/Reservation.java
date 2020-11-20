package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

public class Reservation implements Comparable<Reservation> {

  public int id;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  public Resource resource;

  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  @JsonIdentityReference(alwaysAsId = true)
  public User user;

  public Date from;
  public Date to;

  public Reservation() {
  }

  public Reservation(int id, Resource resource, User user, Date from, Date to) {
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
