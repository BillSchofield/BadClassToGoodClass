package org.bill.bad_class_to_good_class;

import org.joda.time.DateTime;

public class GoodFlightClass {
    private final String origin;
    private final String destination;
    private final DateTime departureTime;
    private final DateTime arrivalTime;

    public GoodFlightClass(String origin, String destination, DateTime departureTime, DateTime arrivalTime) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public boolean isBeforeNow() {
        return departureTime.isBeforeNow();
    }

    public boolean isOrigin(String station) {
        return origin.equals(station);
    }
}
