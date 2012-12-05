package org.bill.bad_class_to_good_class;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GoodFlightFactory {
    public GoodFlightClass createFromFile(String flightFileName) throws FileNotFoundException {
        Scanner scanner =  new Scanner(new BufferedReader(new FileReader(flightFileName)));
        String origin = scanner.nextLine();
        String destination = scanner.nextLine();
        DateTime departureTime = new DateTime(scanner.nextLine());
        DateTime arrivalTime = new DateTime(scanner.nextLine());
        return new GoodFlightClass(origin, destination, departureTime, arrivalTime);
    }
}
