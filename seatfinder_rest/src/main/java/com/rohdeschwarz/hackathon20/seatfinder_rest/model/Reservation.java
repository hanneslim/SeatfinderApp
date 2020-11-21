package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.sql.Timestamp;

public class Reservation implements Comparable<Reservation> {

  public int id;
  public Resource resource;

  public User user;

  public Timestamp from;
  public Timestamp to;

//  public Reservation(String usr, String res, Timestamp from, Timestamp to) {
//    this.resource = new Resource(0, res, new Coordinates(), new Shape());
//
//    this.user = new User(0, usr, "Krokodil" );
//
//    this.from = from;
//    this.to = to;
//  }

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
