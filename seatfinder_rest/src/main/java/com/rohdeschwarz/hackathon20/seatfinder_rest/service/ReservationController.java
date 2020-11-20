package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ReservationController {

  @GetMapping("/reservation/{id}")
  public Reservation getReservation(@PathVariable(value="id") String id) {
    return new Reservation(Integer.parseInt(id), new Resource(1, "Arbeitsplatz "+id, new Coordinates(),
      new Shape()), new User(), new Date(), new Date());
  }

  @PostMapping("/reservation")
  public Reservation postReservation(@RequestBody ReservationRequest reservationRequest){
    return new Reservation(42,
      new Resource(reservationRequest.resource, "mockresource", new Coordinates(0.01, 0.02, 3.0), new Shape("svg here")),
      new User(reservationRequest.user, "mockuser"),
      reservationRequest.from,
      reservationRequest.to);
  }

}
