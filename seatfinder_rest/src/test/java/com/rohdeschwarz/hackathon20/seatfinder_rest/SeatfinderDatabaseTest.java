package com.rohdeschwarz.hackathon20.seatfinder_rest;

import com.rohdeschwarz.hackathon20.seatfinder_rest.database.Mapper;
import com.rohdeschwarz.hackathon20.seatfinder_rest.database.Scheduler;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

@SpringBootTest
public class SeatfinderDatabaseTest {

  private Reservation setupSingleReservation() {
    Timestamp from = new Timestamp( 2020, 11, 20, 19,0,0,0);
    Timestamp to = new Timestamp( 2020, 11,20, 20,0,0,0);
    Reservation r = new Reservation( "me", "desk", from , to );
    return r;
  }

  private Reservation setupAnotherReservation() {
    Timestamp from = new Timestamp( 2020, 11, 20, 20,0,0,0);
    Timestamp to = new Timestamp( 2020, 11,20, 21,0,0,0);
    Reservation r = new Reservation( "me", "desk", from , to );
    return r;
  }

  @Test
  void schedulerInitsEmpty() {
    Scheduler s = new Scheduler("");
    Reservation r = setupSingleReservation();
    assert( s.canReserve( r ));
  }

  @Test
  void schedulerCantReserveTwice() {
    Scheduler s = new Scheduler("");
    Reservation r = setupSingleReservation();
    s.addReservation(r);
    assert( !s.canReserve(r) );
  }

  @Test
  void schedulerReservesTwoSlots() {
    Scheduler s = new Scheduler("");
    Reservation r1 = setupSingleReservation();
    Reservation r2 = setupAnotherReservation();
    s.addReservation(r1);
    assert( !s.canReserve(r1) );
    assert( s.canReserve(r2) );
  }


  @Test
  void schedulerSerializes() throws IOException {
    Scheduler s = new Scheduler("schedule.json");
    Reservation r = setupSingleReservation();
    s.addReservation(r);
    assert( s.saveSchedule() );
  }

  @Test
  void schedulerDeserializes() throws IOException {
    Scheduler s = new Scheduler( "schedule.json");
    Reservation r1 = setupSingleReservation();
    Reservation r2 = setupAnotherReservation();
    s.addReservation(r1);
    s.addReservation(r2);
    if (s.saveSchedule() ) {
      s = new Scheduler("schedule.json");
    }
    assert( !s.canReserve(r2) );
  }

  @Test
  void mapperSerializes() throws IOException {
    Mapper m = new Mapper("site.json");
    assert( m.saveToDefaultFile() );
  }

  @Test
  void mapperDeserializes() {
    Mapper m;
    File f = new File( "site.json");
    assert( f.exists() );
    m = new Mapper(f.getName());
    assert(m.getSiteName().equals("MyDefaultName"));
  }
}
