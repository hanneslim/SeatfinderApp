package com.rohdeschwarz.hackathon20.seatfinder_rest.service;

import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class ReservationController {

  @GetMapping("/reservation/{id}")
  public Reservation getReservation(@PathVariable(value="id") String id) {
    return new Reservation(new Resource(Integer.parseInt(id), "Arbeitsplatz "+id, new Coordinates(),
      new Shape()), new User(), new Timestamp(0), new Timestamp(0));
  }

  @PostMapping("/reservation")
  public ResponseEntity<String> postReservation(@RequestBody Reservation reservation){
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
