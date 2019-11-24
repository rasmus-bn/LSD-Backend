package logic;

import contract.dto.FFNCCIdenitfier;
import contract.dto.FlightOffer;
import contract.dto.PNRIdentifier;
import contract.dto.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Date;

public class logicHandler {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    Flights f = new Flights();
    Booking b = new Booking();
    logic.User u = new logic.User();

    public logicHandler() {
        emf = Persistence.createEntityManagerFactory("sebastian");
        em = emf.createEntityManager();
    }

    public contract.dto.User authUser(contract.dto.User user){
        return u.authUser(em, user);
    }

    public contract.dto.Booking getBookingByPNR(PNRIdentifier pnr) {
        return b.getBookingByPNR(em, pnr);
    }

    public boolean removeBookingByPNR(PNRIdentifier pnr) {
        return b.removeBookingByPNR(em, pnr);
    }

    public contract.dto.Booking createBooking(FlightOffer flightOffer,
                                              FFNCCIdenitfier ffncc, Collection<Passenger> collection) {
        return b.createBooking(em, flightOffer, ffncc, collection);
    }

    public Collection<FlightOffer> getOffers(Date start, Date end,
                                                    String originAirport, String destAirport, boolean oneWay) {
        return f.getOffers(em, start, end, originAirport, destAirport, oneWay);
    }

    public entities.dto.Flight findFlight(entities.dto.FlightRoute fr){
        return f.findFlight(em, fr);
    }

    public entities.dto.Flight findFlightOnContract(contract.dto.Flight f_){
        return f.findFlightManuel(em, f_);
    }

}
