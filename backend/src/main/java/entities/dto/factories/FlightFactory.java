package entities.dto.factories;

import entities.dto.Flight;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class FlightFactory {
    public static List getByDateAndAirport(EntityManager em, Date d1, String originAirport, String destAirport) {
        Timestamp ts1 = new Timestamp(d1.getTime());
        Timestamp ts2 = new Timestamp(d1.getTime() + 86399999l);
        return em.createQuery("SELECT F FROM Flight F WHERE f.depDate BETWEEN  :datestart AND :dateend")
                .setParameter("datestart", ts1)
                .setParameter("dateend", ts2)
                .getResultList();
//        return em.createQuery("SELECT F FROM Flight F WHERE F.depDate BETWEEN :datestart AND :dateend AND F.depAirport.Name = :originairport AND F.arrAirport.Name = :destAirport", Flight.class)
//                .setParameter("datestart", ts1)
//                .setParameter("dateend", ts2)
//                .setParameter("originairport", originAirport)
//                .setParameter("destAirport", destAirport)
//                .getResultList();
    }
}
