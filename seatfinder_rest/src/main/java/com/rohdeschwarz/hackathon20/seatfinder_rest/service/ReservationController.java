package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class ReservationController {

  @GetMapping("/reservation/{id}")
  @CrossOrigin
  public Reservation getReservation(@PathVariable(value="id") String id) {
    return new Reservation(Integer.parseInt(id), new Resource(Integer.parseInt(id), "Arbeitsplatz "+id, new Coordinates(),
      new Shape()), new User(), new Timestamp(0), new Timestamp(0));
  }

  @PostMapping("/reservation")
  @CrossOrigin
  public Reservation postReservation(@RequestBody ReservationRequest reservationRequest){
    return new Reservation(42,
      new Resource(reservationRequest.resource, "mockresource", new Coordinates(0.01, 0.02, 3.0), new Shape("svg here")),
      new User(1, "mockuser", "mockteam"),
      reservationRequest.from,
      reservationRequest.to);
  }

}
