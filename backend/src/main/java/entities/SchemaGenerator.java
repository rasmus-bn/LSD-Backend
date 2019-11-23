package entities;

import entities.dto.Airplane;
import entities.factory.FlightInstanceFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class SchemaGenerator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();


        Airplane a = new Airplane(200, "720");
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();

//        basicSetup(em);
//        query(em);
//        inertData(em);
//        System.out.println(em.getReference(FlightInstance.class, 1));
//        System.out.println(em.getReference(FlightInstance.class, 2));
    }

    public static void inertData(EntityManager em){
        Random  r = new Random();

        // Generate airlines and flights
        ArrayList<entities.Airline> airlines = new ArrayList();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("airlines");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        try {
            em.getTransaction().begin();
            for (String line; (line = reader.readLine()) != null;) {
                String[] content = line.split("\t");
                entities.Airline airline = new entities.Airline(content[1], content[0], new ArrayList<>());
                int amount = r.nextInt(10)+1;
                for(int i = 0; i < amount; i++){
                    entities.Flight flight = new entities.Flight(200, r.nextInt(1000));
                    airline.getFlightId().add(flight);
                    em.persist(flight);
                }
                em.persist(airline);
                em.getTransaction().commit();
                airlines.add(airline);
            }
        } catch (IOException e){

        }
    }

    public static void basicSetup(EntityManager em){
        entities.Flight flight1 = new entities.Flight(200, 341);
        entities.Flight flight2 = new entities.Flight(200, 298);
        entities.Country country1 = new entities.Country("Denmark", TimeZone.getTimeZone("Europe/Copenhagen"));
        entities.Country country2 = new entities.Country("Sweden", TimeZone.getTimeZone("Europe/Stockholm"));
        entities.Airport airport1 = new entities.Airport("Copenhagen", "cph", country1);
        entities.Airport airport2 = new entities.Airport("Stockholm", "arn", country2);
        entities.Airline airline = new entities.Airline("SAS", "AS", new ArrayList<>());
        airline.getFlightId().add(flight1);
        airline.getFlightId().add(flight2);
        entities.FlightInstance fi1 = new FlightInstance(flight1.getCapacity(), 200.0, "Monday", new Timestamp(10000l), new Timestamp(100000l), airport1, airport2, flight1);
        entities.FlightInstance fi2 = new FlightInstance(flight1.getCapacity(), 200.0, "tuesdag", new Timestamp(100000000l), new Timestamp(100000000000l), airport2, airport1, flight1);
        em.getTransaction().begin();
        em.persist(flight1);
        em.persist(flight2);
        em.persist(country1);
        em.persist(country2);
        em.persist(airport1);
        em.persist(airport2);
        em.persist(fi1);
        em.persist(fi2);
        em.persist(airline);
        em.getTransaction().commit();
    }

    public static void query(EntityManager em){
        List<FlightInstance> t = FlightInstanceFactory.getByDateAndAirport(em,new Date(70, 0, 1), "Stockholm", "Copenhagen");
        for (FlightInstance f: t) {
            System.out.println(f.getId());
            System.out.println(f.getSeats());
            System.out.println(f.getOriginAirport().getName());
        }
    }
}

//    public static void createCountry(EntityManager em, Collection<Country> countries){
//       Country country = em.getReference(Country.class, 201);
//        System.out.println(country.getTimeZone().getID());


