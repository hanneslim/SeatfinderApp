package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

import java.sql.Timestamp;

public class ReservationRequest {
  public int resource;
  public int user;
  public Timestamp from;
  public Timestamp to;
}
