package com.rohdeschwarz.hackathon20.seatfinder_rest.database;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Reservation;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.Schedule;


import java.io.File;
import java.io.IOException;

public class Scheduler {
  private String defaultFile = "schedule.json";
  private Schedule schedule;

  public Scheduler( String loadFromFile ) {
    schedule = new Schedule();
    if ( !loadFromFile.isEmpty() )
      defaultFile = loadFromFile;

    File f = new File( loadFromFile );
    if (f.exists()) {
      try {
        initSchedule();
      } catch (IOException e) {
        schedule = new Schedule();
      }
    }
  }

  public boolean canReserve( Reservation reservation) {
    boolean reserved = false;
    for ( Reservation r : schedule.reservations ) {
      if ( r.resource.id == reservation.resource.id
        && reservation.to.compareTo(r.from) > 0
        && reservation.from.compareTo(r.to) < 0 ) {
        reserved = true;
        break;
      }
    }
    return !reserved;
  }

  public void addReservation(Reservation reservation) {
    if ( canReserve( reservation ) )
      schedule.reservations.add(reservation);
  }

  private void initSchedule() throws IOException {
    ObjectMapper om = new ObjectMapper();
    schedule = om.readValue(new File(defaultFile), Schedule.class );
  }

  public boolean saveSchedule() throws IOException {
    ObjectMapper om = new ObjectMapper();
    File f = new File(defaultFile);
    om.writeValue( f, schedule);
    return f.exists();
  }


}
