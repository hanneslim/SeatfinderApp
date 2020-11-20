package com.rohdeschwarz.hackathon20.seatfinder_rest.model;

public class Criterion {
  public int id;
  public String name;
  public int priority;
  public Type type;
  public String value;

  public enum Type{
    BOOL,LIST,STRING,INT
  }
}
