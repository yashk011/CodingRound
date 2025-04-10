package org.example.LLDQuestions.cabbooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trip {
    String id;
    Rider rider;
    Cab cab;
    double amount;
    TripStatus tripStatus;
    Location source;
    Location destination;


    public void endTrip() {

        this.tripStatus = TripStatus.END;
    }
}
