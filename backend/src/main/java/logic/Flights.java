package logic;

import contract.dto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

public class Flights {

    // Fucking mess den her
    public Collection<FlightOffer> getOffers(User user, Date start, Date end, String depIata, String destIata, boolean oneWay){
        Collection<FlightOffer> offers = new ArrayList();
        Collection<Flight> outBound = new ArrayList();
//        Date now = new Date(1,1,1);
//        Airplane plane = new Airplane(200, "123");
//        Airport airport = new Airport(TimeZone.getTimeZone("Europe/Copenhagen"),"CPH","CPH");
//        outBound.add(new Flight(1, now, now, plane,airport, airport));
//        offers.add(new FlightOffer(200.0, oneWay, new FlightRoute(true, outBound), new FlightRoute(true, outBound)));
        return offers;
    }
}
