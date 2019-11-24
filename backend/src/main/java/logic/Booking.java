package logic;

import contract.dto.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

public class Booking {
    Flights flights = new Flights();

    public contract.dto.Booking getBookingByPNR(EntityManager em, PNRIdentifier pnr) {
        entities.dto.Booking tmp = em.createQuery("SELECT B FROM Booking b WHERE b.pnr =:pnr",
                entities.dto.Booking.class)
                .setParameter("pnr", pnr.getPnr())
                .getSingleResult();
        return tmp.toDto();
    }

    public boolean removeBookingByPNR(EntityManager em, PNRIdentifier pnr) {
        entities.dto.Booking tmp = em.createQuery("SELECT B FROM Booking b WHERE b.pnr =:pnr",
                entities.dto.Booking.class)
                .setParameter("pnr", pnr.getPnr())
                .getSingleResult();
        em.getTransaction().begin();
        em.remove(tmp);
        em.getTransaction().commit();
        if (tmp != null) {
            return true;
        } else {
            return false;
        }
    }

    public contract.dto.Booking createBooking(EntityManager em, FlightOffer flightOffer,
                                              FFNCCIdenitfier ffncc, Collection<Passenger> collection) {
        double price = flightOffer.getPrice();
        Collection<entities.dto.Ticket> tickets = new ArrayList();
        entities.dto.FlightOffer fo = new entities.dto.FlightOffer(flightOffer);

        entities.dto.FlightRoute outFlightRoute = fo.getOutRoute();
        entities.dto.FlightRoute returnRoute = fo.getReturnRoute();

        entities.dto.Flight of = flights.findFlight(em, outFlightRoute);
        entities.dto.Flight rf = flights.findFlight(em, returnRoute);

        for (Passenger p: collection) {
            tickets.add(new entities.dto.Ticket(new entities.dto.Passenger(p), of));
            tickets.add(new entities.dto.Ticket(new entities.dto.Passenger(p), rf));
        }

        entities.dto.Booking tmp = new entities.dto.Booking(price, ffncc.getFfcc(), tickets, outFlightRoute, returnRoute);
        em.getTransaction().begin();
        em.persist(tmp);
        em.getTransaction().commit();
        return tmp.toDto();
    }
}
