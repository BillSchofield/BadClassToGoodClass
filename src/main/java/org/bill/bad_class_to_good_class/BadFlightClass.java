package org.bill.bad_class_to_good_class;

import org.joda.time.DateTime;

import javax.sql.RowSet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class BadFlightClass {

    String origin;
    String destination;
    DateTime departureTime;
    DateTime arrivalTime;

    public BadFlightClass(String flightFileName) throws FileNotFoundException {
        Scanner scanner =  new Scanner(new BufferedReader(new FileReader(flightFileName)));
        origin = scanner.nextLine();
        destination = scanner.nextLine();
        departureTime = new DateTime(scanner.nextLine());
        arrivalTime = new DateTime(scanner.nextLine());
    }

    public BadFlightClass(RowSet rowSet) throws SQLException {
        origin = rowSet.getString(rowSet.findColumn("origin"));
        destination = rowSet.getString(rowSet.findColumn("destination"));
        departureTime = new DateTime(rowSet.getString(rowSet.findColumn("departureTime")));
        arrivalTime = new DateTime(rowSet.getString(rowSet.findColumn("arrivalTime")));
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public DateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
    }

    public DateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(DateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
