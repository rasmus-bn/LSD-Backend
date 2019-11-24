package logic;

import contract.dto.*;

import javax.persistence.EntityManager;
import java.util.Collection;

public class Booking {

    public contract.dto.Booking getBookingByPNR(EntityManager em, PNRIdentifier pnr) {
        entities.dto.Booking tmp = em.createQuery("SELECT B FROM Booking b WHERE b.pnr.pnr =:pnr",
                entities.dto.Booking.class)
                .setParameter("pnr", pnr)
                .getSingleResult();
        return tmp.toDto();
    }

    public boolean removeBookingByPNR(EntityManager em, PNRIdentifier pnr) {
        entities.dto.Booking tmp = em.createQuery("SELECT B FROM Booking b WHERE b.pnr.pnr =:pnr",
                entities.dto.Booking.class)
                .setParameter("pnr", pnr)
                .getSingleResult();
        em.remove(tmp);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }
    }

    public contract.dto.Booking createBooking(EntityManager em, FlightOffer flightOffer,
                                              FFNCCIdenitfier ffncc, Collection<Passenger> collection) {
        entities.dto.Booking tmp = new entities.dto.Booking();
        tmp.setPrice(flightOffer.getPrice());
        tmp.setFfncc(new entities.dto.FFNCCIdenitfier(ffncc));
        tmp.setFlightRoute(new entities.dto.FlightRoute(flightOffer.getOutRoute()));
        if(flightOffer.getReturnRoute() != null){
            tmp.setReturnRoute(new entities.dto.FlightRoute(flightOffer.getReturnRoute()));
        }
        em.persist(tmp);
        return tmp.toDto();
    }
}
