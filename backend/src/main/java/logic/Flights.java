package logic;

import contract.dto.*;
import entities.dto.Carrier;
import entities.dto.Flight;
import entities.dto.FlightOffer;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.*;

public class Flights {

    public Collection<contract.dto.FlightOffer> getOffers(EntityManager em, Date start, Date end,
                                             String originAirport, String destAirport, boolean oneWay) {
        entities.dto.FlightRoute inBound = null;
        if(!oneWay) {
            inBound = new entities.dto.FlightRoute(true, findFlightOffer(em, end, destAirport, originAirport));
        }
        entities.dto.FlightRoute outBound = new entities.dto.FlightRoute(true, findFlightOffer(em, start, originAirport, destAirport));
        Collection<contract.dto.FlightOffer> fo = new ArrayList();
        fo.add(new entities.dto.FlightOffer(200.0, oneWay, outBound, inBound).toDto());

        return fo;
    }

    private static List<Flight> findFlightOffer(EntityManager em, Date d1, String originAirport, String destAirport){
        Timestamp ts1 = new Timestamp(d1.getTime());
        Timestamp ts2 = new Timestamp(d1.getTime() + 86399999l);
        List<Flight> tmp = em.createQuery("SELECT F FROM Flight F WHERE f.depDate BETWEEN :datestart AND " +
                ":dateend AND F.depAirport.name = :originairport AND F.arrAirport.name = :destAirport", Flight.class)
                .setParameter("datestart", ts1)
                .setParameter("dateend", ts2)
                .setParameter("originairport", originAirport)
                .setParameter("destAirport", destAirport)
                .getResultList();
        return tmp;
    }

    public entities.dto.Flight findFlight(EntityManager em, entities.dto.FlightRoute fr){
        ArrayList<entities.dto.Flight> f = (ArrayList<entities.dto.Flight>) fr.getFlights();
        return em.createQuery("SELECT F FROM Flight F WHERE F.depAirport.name = :dA AND F.arrAirport.name = :aA AND F.depDate = :time", entities.dto.Flight.class)
                .setParameter("dA", f.get(0).getDepAirport().getName())
                .setParameter("aA", f.get(0).getArrAirport().getName())
                .setParameter("time", f.get(0).getDepDate())
                .getResultList().get(0);
    }

    public entities.dto.Flight findFlightManuel(EntityManager em, contract.dto.Flight f){
        return em.createQuery("SELECT F FROM Flight F WHERE F.depAirport.name = :dA AND F.arrAirport.name = :aA AND F.depDate = :time", entities.dto.Flight.class)
                .setParameter("dA", f.getDepAirport().getName())
                .setParameter("aA", f.getArrAirport().getName())
                .setParameter("time", f.getDepDate())
                .getResultList().get(0);
    }

    public Carrier findCarrier(EntityManager em, String iata) {
        return em.createQuery("SELECT C FROM Carrier C WHERE C.iata = :iata", Carrier.class)
                .setParameter("iata", iata)
                .getSingleResult();
    }
}
