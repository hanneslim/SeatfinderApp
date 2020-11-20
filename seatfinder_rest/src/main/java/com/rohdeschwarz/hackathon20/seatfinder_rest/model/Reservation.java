package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.Date;

public class Reservation implements Comparable<Reservation> {
  public Resource resource;
  public User user;
  public Date from;
  public Date to;

  public Reservation() {
  }

  public Reservation(Resource resource, User user, Date from, Date to) {
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
