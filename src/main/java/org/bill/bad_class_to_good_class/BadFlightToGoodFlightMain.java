package org.bill.bad_class_to_good_class;

import org.joda.time.DateTime;
import java.io.FileNotFoundException;

/*
    Consider these concepts when comparing the BadFlightClass and GoodFlightClass:

    * How easy would it be to use this class in a different program?
    * How easy would it be to unit test these classes?
    * What do the dependencies look like?
    * How hard would it be to mock these classes?
    * How do these classes honor the following principles: single-responsibility, open-close, and cohesion?

 */



public class BadFlightToGoodFlightMain {

    public static final String CITY_I_AM_IN = "DAL";

    public static void main(String[] args) throws FileNotFoundException {
        checkDepartureForBadFlight();
        checkDepartureForGoodFlight();
    }

    private static void checkDepartureForBadFlight() throws FileNotFoundException {
        BadFlightClass badFlight = new BadFlightClass("fileNameForFlight.txt");

        if (badFlight.departureTime.isBeforeNow()){
            System.out.println("Flight has already left");
        }

        if (badFlight.getOrigin().equals(CITY_I_AM_IN)){
            System.out.println("You are at the correct airport");
        } else {
            System.out.println("You are at the wrong airport");
        }
    }

    private static void checkDepartureForGoodFlight() {
        GoodFlightClass goodFlight = new GoodFlightClass(CITY_I_AM_IN, "ATL", new DateTime(0, 0, 0, 0, 0), new DateTime(1, 1, 1, 1, 1));

        if (goodFlight.isBeforeNow()){
            System.out.println("Flight has already left");
        }

        if (goodFlight.isOrigin(CITY_I_AM_IN)){
            System.out.println("You are at the correct airport");
        } else {
            System.out.println("You are at the wrong airport");
        }
    }

    private static void butWeNeedToCreateFlightsFromDataFiles() throws FileNotFoundException {
        GoodFlightClass flight = new GoodFlightFactory().createFromFile("fileNameForFlight.txt");


    }
}
