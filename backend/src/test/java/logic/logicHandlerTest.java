package logic;

import entities.dto.*;

import javax.persistence.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class logicHandlerTest {
    @PersistenceContext(unitName = "mydb")
    static EntityManagerFactory emf = null;

    static EntityManager em = null;

    @org.junit.jupiter.api.BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("sebastian");
        em = emf.createEntityManager();

        Carrier norwegian = new Carrier("Norwegian Air International", "D8");

        Airport cph = new Airport(TimeZone.getTimeZone("Europe/Copenhagen"), "CPH", "Copenhagen Airport");
        Airport sfx = new Airport(TimeZone.getTimeZone("Europe/Berlin"), "SFX", "Berlin Airport");

        List<Flight> flights = new ArrayList();

        Date currentDate = new Date(119, 10, 25, 00, 00);
        Date endDate = new Date(119, 10,30,40,00);
        while(endDate.after(currentDate)){
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "Norwegian"), cph, sfx, norwegian));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "Norwegian"), sfx, cph, norwegian));
            currentDate.setTime(currentDate.getTime() + 86400000l);
        }

        entities.dto.User user = new entities.dto.User(62, "admin", "admin");

        em.getTransaction().begin();
        em.persist(norwegian);

        em.persist(user);
        em.persist(cph);
        em.persist(sfx);
        for(Flight f : flights){
            em.persist(f);
        }

        em.getTransaction().commit();
//        em.close();
    }

    @org.junit.jupiter.api.Test
    void authUserCorrect() {
        logicHandler lh = new logicHandler(em);
        assertEquals(new contract.dto.User(1, 62, "admin", "admin"), lh.authUser(new contract.dto.User(1, 62, "admin", "admin")));
    }

    @org.junit.jupiter.api.Test
    void authUserIncorrect() {
        logicHandler lh = new logicHandler(em);
        assertNull(lh.authUser(new contract.dto.User(99, 62, "admin", "adm")));
    }

    @org.junit.jupiter.api.Test
    void getBookingByPNR() {
        logicHandler lh = new logicHandler(em);
        Date d1 = new Date(119, 10, 25, 00, 00);
        Date d2 = new Date(119, 10, 27, 00, 00);

        String originAirport = "Copenhagen Airport";
        String destAirport = "Berlin Airport";
        Collection<contract.dto.FlightOffer> FlightOffers = lh.getOffers(d1, d2, originAirport, destAirport, false);
        for (contract.dto.FlightOffer fo: FlightOffers) {
            for (contract.dto.Flight fOutbound: fo.getOutRoute().getFlights()) {
                System.out.println("fOutbound " + fOutbound.getId() + " " + fOutbound.getDepAirport().getName() + " " + fOutbound.getDepDate());
            }
            for (contract.dto.Flight fInbound: fo.getReturnRoute().getFlights()){
                System.out.println("fInbound " + fInbound.getId() + " " + fInbound.getDepAirport().getName() + " " + fInbound.getDepDate());
            }
        }
        ArrayList<contract.dto.FlightOffer> foA = (ArrayList<contract.dto.FlightOffer>) FlightOffers;
        Collection<contract.dto.Passenger> p = new ArrayList<>();
        p.add(new contract.dto.Passenger("Test", "McBoaty", new Date(1,1,1,1,1,1)));
        System.out.println(FlightOffers.isEmpty());
        System.out.println(foA);
        lh.createBooking(foA.get(0), new contract.dto.FFNCCIdenitfier("test"), p);
        assertEquals(lh.getBookingByPNR(new contract.dto.PNRIdentifier(1)).getFfncc().getFfcc(), "test");
    }

    @org.junit.jupiter.api.Test
    void removeBookingByPNR() {

    }

    @org.junit.jupiter.api.Test
    void createBooking() {
        logicHandler lh = new logicHandler(em);
        Date d1 = new Date(119, 10, 25, 00, 00);
        Date d2 = new Date(119, 10, 27, 00, 00);

        String originAirport = "Copenhagen Airport";
        String destAirport = "Berlin Airport";
        Collection<contract.dto.FlightOffer> FlightOffers = lh.getOffers(d1, d2, originAirport, destAirport, false);
        ArrayList<contract.dto.FlightOffer> foA = (ArrayList<contract.dto.FlightOffer>) FlightOffers;
        Collection<contract.dto.Passenger> p = new ArrayList<>();
        p.add(new contract.dto.Passenger("Test", "McBoaty", new Date(1,1,1,1,1,1)));
        lh.createBooking(foA.get(0), new contract.dto.FFNCCIdenitfier("test"), p);
    }
}