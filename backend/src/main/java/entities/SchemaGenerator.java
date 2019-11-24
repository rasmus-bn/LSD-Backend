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

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();

//        Carrier sas = new Carrier("Scandinavian Airlines(SAS)", "SK");
//        Carrier norwegian = new Carrier("Norwegian Air International", "D8");
//        Carrier lufthansa = new Carrier("Lufthansa", "LF");
//        Carrier emirates = new Carrier("Emirates Airlines", "EK");

        Airport cph = new Airport(TimeZone.getTimeZone("Europe/Copenhagen"), "CPH", "Copenhagen Airport");
        Airport sfx = new Airport(TimeZone.getTimeZone("Europe/Berlin"), "SFX", "Berlin Airport");
        Airport cdg = new Airport(TimeZone.getTimeZone("Europe/Paris"), "CDG", "Charles De Gaule");
        Airport stn = new Airport(TimeZone.getTimeZone("Europe/London"), "STN", "Stansted Airport");
        Airport bcn = new Airport(TimeZone.getTimeZone("Europe/Barcelona"), "BCN", "Barcelona International Airport");

        List <Airplane> airplanes = new ArrayList();
        Airplane airplaneSAS = new Airplane(200, "sas");
        Airplane airplaneSAS1 = new Airplane(200, "sas");
        Airplane airplaneSAS2 = new Airplane(200, "sas");
        Airplane airplaneSAS3 = new Airplane(200, "sas");

        Airplane airplaneNor = new Airplane(200, "norwegian");
        Airplane airplaneNor1 = new Airplane(200, "norwegian");
        Airplane airplaneNor2 = new Airplane(200, "norwegian");
        Airplane airplaneNor3 = new Airplane(200, "norwegian");

        Airplane airplaneEmi = new Airplane(200, "emirates");
        Airplane airplaneEmi1 = new Airplane(200, "emirates");
        Airplane airplaneEmi2 = new Airplane(200, "emirates");
        Airplane airplaneEmi3 = new Airplane(200, "emirates");

        Airplane airplaneLuft = new Airplane(200, "lufthansa");
        Airplane airplaneLuft1 = new Airplane(200, "lufthansa");
        Airplane airplaneLuft2 = new Airplane(200, "lufthansa");
        Airplane airplaneLuft3 = new Airplane(200, "lufthansa");

        List<Flight> flights = new ArrayList();


        Date currentDate = new Date(119, 10, 25, 00, 00);
        Date endDate = new Date(119, 10,30,40,00);
        System.out.println(endDate);
        while(endDate.after(currentDate)){
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),airplaneSAS1, cph, stn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),airplaneSAS2, cph, bcn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),airplaneSAS3, cph, cdg));

            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),airplaneNor, cph, sfx));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),airplaneNor3, sfx, cph));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),airplaneNor1, cph, stn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),airplaneNor2, cph, bcn));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 19)), new java.sql.Date(currentDate.getTime() + (3600000l * 21)),airplaneNor3, cph, cdg));

//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 11)), new java.sql.Date(currentDate.getTime() + (3600000l * 13)),airplaneLuft, cph, sfx));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),airplaneLuft1, cph, stn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),airplaneLuft2, cph, bcn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),airplaneLuft3, cph, cdg));

//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),airplaneEmi, cph, sfx));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),airplaneEmi1, cph, stn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),airplaneEmi2, cph, bcn));
            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 20)), new java.sql.Date(currentDate.getTime() + (3600000l * 22)),airplaneEmi3, cph, cdg));

            currentDate.setTime(currentDate.getTime() + 86400000l);
        }

        em.getTransaction().begin();
//        em.persist(sas);
//        em.persist(norwegian);
//        em.persist(lufthansa);
//        em.persist(emirates);
        em.persist(cph);
        em.persist(sfx);
        em.persist(stn);
        em.persist(cdg);
        em.persist(bcn);
        for(Flight f : flights){
            em.persist(f);
//            System.out.println("Adding flight!");
        }

        em.getTransaction().commit();
        Date d1 = new Date(119, 10, 25, 00, 00);
        Date d2 = new Date(119, 10, 27, 00, 00);

        String originAirport = "Copenhagen Airport";
        String destAirport = "Berlin Airport";
        Collection<contract.dto.FlightOffer> FlightOffers = f.getOffers(em, d1, d2, originAirport, destAirport, false);
//         flightsList = Flights.getByDateAndAirport(em, d1, originAirport, destAirport);
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
        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("blablablbal"), p);
        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("adsakjhjdak"), p);
        b.createBooking(em, foA.get(0), new FFNCCIdenitfier("jkadskjdsal"), p);
        b.removeBookingByPNR(em, new contract.dto.PNRIdentifier(1l));
        System.out.println(b.getBookingByPNR(em, new contract.dto.PNRIdentifier(2l)).getFfncc());
    }
}

