package com.rohdeschwarz.hackathon20.seatfinder_rest;

import com.rohdeschwarz.hackathon20.seatfinder_rest.database.Mapper;
import com.rohdeschwarz.hackathon20.seatfinder_rest.database.Scheduler;
import com.rohdeschwarz.hackathon20.seatfinder_rest.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  @Test
  void mapSerializes() {
    try {
      Mapper m = mapperFillMap("map.json");
    }
    catch (IOException e) {
      assert(false);
    }
    File f = new File("map.json" );
    assert( f.exists() );
  }


  private Mapper mapperFillMap( String filename) throws IOException {
    Mapper m = new Mapper(filename);
    ArrayList<Space> spaces = new ArrayList<>();
    Shape buero = new Shape("<rect id=\"svg_1\" height=\"385\" width=\"441\" y=\"40.45313\" x=\"56.5\"/>");
    Shape desk1 = new Shape("<rect id=\"svg_2\" height=\"196\" width=\"65\" y=\"62.45313\" x=\"101.5\"/>");
    Shape desk2 = new Shape("<rect id=\"svg_3\" height=\"207\" width=\"70\" y=\"66.45313\" x=\"224.5\"/>");
    Shape desk3 = new Shape("<rect id=\"svg_4\" height=\"214\" width=\"70\" y=\"59.45313\" x=\"369.5\"/>");
    Shape desk4 = new Shape("<rect id=\"svg_5\" height=\"72\" width=\"202\" y=\"304.45313\" x=\"93.5\"/>");
    Shape heat1 = new Shape("<rect id=\"heat1\" height=\"36\" width=\"37\" y=\"382.45313\" x=\"420.5\"/>");
    Shape door1 = new Shape("<rect id=\"door1\" height=\"94\" width=\"1\" y=\"281.45313\" x=\"493.5\"/>");
    Resource d1 = new Resource(51, "Schreibtisch 1", new Coordinates(101.5, 62.45, 1), desk1 );
    Resource d2 = new Resource(52, "Schreibtisch 2", new Coordinates(224.5, 66.45, 1), desk2 );
    Resource d3 = new Resource(53, "Schreibtisch 3", new Coordinates(369.5, 59.45, 1), desk3 );
    Resource d4 = new Resource(54, "Schreibtisch 4", new Coordinates(93.5, 304.45, 1), desk4 );
    Resource h1 = new Resource(61, "Heizung 1", new Coordinates(420.5, 382.45, 1), heat1, false);
    Resource dr = new Resource(71, "Bürotüre 1", new Coordinates(493.5, 281.45, 1), door1, false );

    Space s1 = new Space(34, "Büro Software", buero, new ArrayList<>(Arrays.asList(d1, d2, d3, d4, h1, dr)));
    Space s2 = new Space(32, "Büro Personal", buero, new ArrayList<>(Arrays.asList(d1, d2, d3, d4, h1, dr)));
    Space ov = new Space(22, "Übersichtsplan", buero, new ArrayList<>(Arrays.asList(d1, d2, d3)));
    m.setSite("MyNiceMap", new ArrayList<>(Arrays.asList(ov) ), new Map(44, "Gebäude 1", new ArrayList<>(Arrays.asList(s1, s2)) ));
    m.saveToDefaultFile();
    return m;
  }
}
