package entities;

import contract.dto.FFNCCIdenitfier;
import entities.dto.*;
import logic.Flights;
import org.eclipse.persistence.exceptions.PersistenceUnitLoadingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class SchemaGenerator {
    static Flights f = new Flights();
    static logic.Booking b = new logic.Booking();
    static logic.User u = new logic.User();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();

        Carrier sas = new Carrier("Scandinavian Airlines(SAS)", "SK");
        Carrier norwegian = new Carrier("Norwegian Air International", "D8");
        Carrier lufthansa = new Carrier("Lufthansa", "LF");
        Carrier emirates = new Carrier("Emirates Airlines", "EK");
        Carrier da = new Carrier("David Airline", "DA");
        Carrier ra = new Carrier("Rasmus Airline", "RA");

        List<Airport> airports = new ArrayList();
        Airport cph = new Airport(TimeZone.getTimeZone("Europe/Copenhagen"), "CPH", "Copenhagen Airport");
        Airport sfx = new Airport(TimeZone.getTimeZone("Europe/Berlin"), "SFX", "Berlin Airport");
        Airport cdg = new Airport(TimeZone.getTimeZone("Europe/Paris"), "CDG", "Charles De Gaule");
        Airport stn = new Airport(TimeZone.getTimeZone("Europe/London"), "STN", "Stansted Airport");
        Airport bcn = new Airport(TimeZone.getTimeZone("Europe/Barcelona"), "BCN", "Barcelona International Airport");
        airports.add(cph);
        airports.add(sfx);
        airports.add(cdg);
        airports.add(stn);
        airports.add(bcn);

        List<User> users = new ArrayList();
        users.add(new User(62, "admin", "admin"));
        users.add(new User(62, "nimda", "nimda"));
        users.add(new User(1, "1qaz", "2wsx"));
        users.add(new User(1, "root", "root"));

        em.getTransaction().begin();
        em.persist(sas);
        em.persist(norwegian);
        em.persist(lufthansa);
        em.persist(emirates);

        for (Airport a: airports) {
            em.persist(a);
        }
        for(User u: users){
            em.persist(u);
        }
        em.getTransaction().commit();

        List<Flight> flights = new ArrayList();

        Date currentDate = new Date(119, 10, 25, 00, 00);
        Date endDate = new Date(120, 11,31,40,00);
        while(endDate.after(currentDate)){
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),new Airplane(200, "sas"), bcn, cph, sas));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),new Airplane(200, "sas"), cdg, cph, sas));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),new Airplane(200, "sas"), stn, cph, sas));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "Norwegian"), cph, sfx, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "Norwegian"), sfx, cph, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),new Airplane(200, "Norwegian"), cph, stn, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),new Airplane(200, "Norwegian"), stn, cph, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),new Airplane(200, "Norwegian"), cph, bcn, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),new Airplane(200, "Norwegian"), bcn, cph, norwegian));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "lufthansa"), cph, stn, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "lufthansa"), stn, cph, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),new Airplane(200, "lufthansa"), cph, bcn, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),new Airplane(200, "lufthansa"), bcn, cph, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),new Airplane(200, "lufthansa"), cph, cdg, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),new Airplane(200, "lufthansa"), cdg, cph, lufthansa));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),new Airplane(200, "Emirates"), cph, stn, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),new Airplane(200, "Emirates"), stn, cph, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),new Airplane(200, "Emirates"), cph, bcn, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),new Airplane(200, "Emirates"), bcn, cph, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 20)), new java.sql.Date(currentDate.getTime() + (3600000l * 22)),new Airplane(200, "Emirates"), cph, cdg, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 20)), new java.sql.Date(currentDate.getTime() + (3600000l * 22)),new Airplane(200, "Emirates"), cdg, cph, emirates));

            for(Airport a: airports){
                for(Airport a1: airports){
                    if(!(a.getIata() == a1.getIata())){
//                        System.out.println(a.getIata() + " " + a1.getIata());
                        em.getTransaction().begin();
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),new Airplane(200, "sas"), a, a1, sas));
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "Norwegian"), a, a1, norwegian));
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),new Airplane(200, "lufthansa"), a, a1, lufthansa));
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),new Airplane(200, "Emirates"), a, a1, emirates));
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),new Airplane(200, "DA"), a, a1, da));
                        em.persist(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 10)), new java.sql.Date(currentDate.getTime() + (3600000l * 13)),new Airplane(200, "RA"), a, a1, ra));
                        em.getTransaction().commit();
                    }
                }
            }

            currentDate.setTime(currentDate.getTime() + 86400000l);
        }
//
//        for(Flight f : flights){
//            em.persist(f);
//        }
        em.getTransaction().commit();


//        Date d1 = new Date(119, 10, 25, 00, 00);
//        Date d2 = new Date(120, 11, 31, 00, 00);
//
//        String originAirport = "Copenhagen Airport";
//        String destAirport = "Berlin Airport";
//        Collection<contract.dto.FlightOffer> FlightOffers = f.getOffers(em, d1, d2, originAirport, destAirport, false);
////         flightsList = Flights.getByDateAndAirport(em, d1, originAirport, destAirport);
//        for (contract.dto.FlightOffer fo: FlightOffers) {
//            for (contract.dto.Flight fOutbound: fo.getOutRoute().getFlights()) {
//                System.out.println("fOutbound " + fOutbound.getId() + " " + fOutbound.getDepAirport().getName() + " " + fOutbound.getDepDate());
//            }
//            for (contract.dto.Flight fInbound: fo.getReturnRoute().getFlights()){
//                System.out.println("fInbound " + fInbound.getId() + " " + fInbound.getDepAirport().getName() + " " + fInbound.getDepDate());
//            }
//        }
//        ArrayList<contract.dto.FlightOffer> foA = (ArrayList<contract.dto.FlightOffer>) FlightOffers;
//        Collection<contract.dto.Passenger> p = new ArrayList<>();
//        p.add(new contract.dto.Passenger("Test", "McBoaty", new Date(1,1,1,1,1,1)));
//        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("blablablbal"), p);
//        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("asdsaddsads"), p);
//        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("kjkjkjkjkkj"), p);
//        System.out.println(u.authUser(em, new contract.dto.User(21, 62, "admin", "admin")));
//        System.out.println(u.authUser(em, new contract.dto.User(21, 62, "admin", "admn")));

    }
}

