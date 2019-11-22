package entities.factory;

import entities.FlightInstance;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class FlightInstanceFactory {

    public static List getByDateAndAirport(EntityManager em, Date d1, String originAirport, String destAirport) {
        Timestamp ts1 = new Timestamp(d1.getTime());
        Timestamp ts2 = new Timestamp(d1.getTime() + 86399999l);
        return em.createQuery("SELECT FI FROM FlightInstance FI WHERE FI.depTime BETWEEN :datestart AND :dateend AND FI.originAirport.Name = :originairport AND FI.destAirport.Name = :destAirport", FlightInstance.class)
                .setParameter("datestart", ts1)
                .setParameter("dateend", ts2)
                .setParameter("originairport", originAirport)
                .setParameter("destAirport", destAirport)
                .getResultList();
    }
}
