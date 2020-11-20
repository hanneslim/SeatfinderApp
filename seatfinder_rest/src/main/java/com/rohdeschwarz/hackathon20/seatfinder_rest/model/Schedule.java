package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.util.TreeSet;

public class Schedule {
  public TreeSet<Reservation> reservations;

  public Schedule() {
  }

  public Schedule(TreeSet<Reservation> reservations) {
    this.reservations = reservations;
  }
}
