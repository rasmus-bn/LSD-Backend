package entities;

import entities.dto.*;
import entities.dto.factories.FlightFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;

public class SchemaGenerator {

    static FlightFactory ff = new FlightFactory();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();

        List<Flight> flights = ff.getByDateAndAirport(em, new Date(119, 10, 25, 00, 00), "CPH", "STN");
        for (Flight f: flights) {
            System.out.println(f.getDepDate() + "\t" + f.getDepAirport().getTimeZone() + "\t" + f.getId());
        }
        //
//        em.createQuery()
//        Carrier sas = new Carrier("Scandinavian Airlines(SAS)", "SK");
//        Carrier norwegian = new Carrier("Norwegian Air International", "D8");
//        Carrier lufthansa = new Carrier("Lufthansa", "LF");
//        Carrier emirates = new Carrier("Emirates Airlines", "EK");
//
//        Airport cph = new Airport(TimeZone.getTimeZone("Europe/Copenhagen"), "CPH", "Copenhagen Airport");
//        Airport sfx = new Airport(TimeZone.getTimeZone("Europe/Berlin"), "SFX", "Berlin Airport");
//        Airport cdg = new Airport(TimeZone.getTimeZone("Europe/Paris"), "CDG", "Charles De Gaule");
//        Airport stn = new Airport(TimeZone.getTimeZone("Europe/London"), "STN", "Stansted Airport");
//        Airport bcn = new Airport(TimeZone.getTimeZone("Europe/Barcelona"), "BCN", "Barcelona International Airport");
//
//        List <Airplane> airplanes = new ArrayList();
//        Airplane airplaneSAS = new Airplane(200, sas);
//        Airplane airplaneSAS1 = new Airplane(200, sas);
//        Airplane airplaneSAS2 = new Airplane(200, sas);
//        Airplane airplaneSAS3 = new Airplane(200, sas);
//
//        Airplane airplaneNor = new Airplane(200, norwegian);
//        Airplane airplaneNor1 = new Airplane(200, norwegian);
//        Airplane airplaneNor2 = new Airplane(200, norwegian);
//        Airplane airplaneNor3 = new Airplane(200, norwegian);
//
//        Airplane airplaneEmi = new Airplane(200, emirates);
//        Airplane airplaneEmi1 = new Airplane(200, emirates);
//        Airplane airplaneEmi2 = new Airplane(200, emirates);
//        Airplane airplaneEmi3 = new Airplane(200, emirates);
//
//        Airplane airplaneLuft = new Airplane(200, lufthansa);
//        Airplane airplaneLuft1 = new Airplane(200, lufthansa);
//        Airplane airplaneLuft2 = new Airplane(200, lufthansa);
//        Airplane airplaneLuft3 = new Airplane(200, lufthansa);
//
//        List<Flight> flights = new ArrayList();
//
//
//        Date currentDate = new Date(119, 10, 25, 00, 00);
//        Date endDate = new Date(120, 11,30,40,00);
//        System.out.println(endDate);
//        while(endDate.after(currentDate)){
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),airplaneSAS1, cph, stn, sas));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),airplaneSAS2, cph, bcn, sas));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),airplaneSAS3, cph, cdg, sas));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),airplaneNor, cph, sfx, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),airplaneNor1, cph, stn, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),airplaneNor2, cph, bcn, norwegian));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 19)), new java.sql.Date(currentDate.getTime() + (3600000l * 21)),airplaneNor3, cph, cdg, norwegian));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 11)), new java.sql.Date(currentDate.getTime() + (3600000l * 13)),airplaneLuft, cph, sfx, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 13)), new java.sql.Date(currentDate.getTime() + (3600000l * 15)),airplaneLuft1, cph, stn, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 15)), new java.sql.Date(currentDate.getTime() + (3600000l * 17)),airplaneLuft2, cph, bcn, lufthansa));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 17)), new java.sql.Date(currentDate.getTime() + (3600000l * 19)),airplaneLuft3, cph, cdg, lufthansa));
//
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 14)), new java.sql.Date(currentDate.getTime() + (3600000l * 16)),airplaneEmi, cph, sfx, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 16)), new java.sql.Date(currentDate.getTime() + (3600000l * 18)),airplaneEmi1, cph, stn, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 18)), new java.sql.Date(currentDate.getTime() + (3600000l * 20)),airplaneEmi2, cph, bcn, emirates));
//            flights.add(new Flight(new java.sql.Date(currentDate.getTime() + (3600000l * 20)), new java.sql.Date(currentDate.getTime() + (3600000l * 22)),airplaneEmi3, cph, cdg, emirates));
//
//            currentDate.setTime(currentDate.getTime() + 86400000l);
//        }
//
//        em.getTransaction().begin();
//        em.persist(sas);
//        em.persist(norwegian);
//        em.persist(lufthansa);
//        em.persist(emirates);
//        em.persist(cph);
//        em.persist(sfx);
//        em.persist(stn);
//        em.persist(cdg);
//        em.persist(bcn);
//        for(Flight f : flights){
//            em.persist(f);
////            System.out.println("Adding flight!");
//        }

//        em.getTransaction().commit();
    }
    private static java.util.Date convertDate(java.sql.Date sqlDate) {
        java.util.Date uDate = new java.util.Date(sqlDate.getTime());
        return uDate;
    }
}
//
//    public static void inertData(EntityManager em){
//        Random  r = new Random();
//
//        // Generate airlines and flights
//        ArrayList<entities.Airline> airlines = new ArrayList();
//
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("airlines");
//        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
//        BufferedReader reader = new BufferedReader(streamReader);
//        try {
//            em.getTransaction().begin();
//            for (String line; (line = reader.readLine()) != null;) {
//                String[] content = line.split("\t");
//                entities.Airline airline = new entities.Airline(content[1], content[0], new ArrayList<>());
//                int amount = r.nextInt(10)+1;
//                for(int i = 0; i < amount; i++){
//                    entities.Flight flight = new entities.Flight(200, r.nextInt(1000));
//                    airline.getFlightId().add(flight);
//                    em.persist(flight);
//                }
//                em.persist(airline);
//                em.getTransaction().commit();
//                airlines.add(airline);
//            }
//        } catch (IOException e){
//
//        }
//    }
//
//    public static void basicSetup(EntityManager em){
//        entities.Flight flight1 = new entities.Flight(200, 341);
//        entities.Flight flight2 = new entities.Flight(200, 298);
//        entities.Country country1 = new entities.Country("Denmark", TimeZone.getTimeZone("Europe/Copenhagen"));
//        entities.Country country2 = new entities.Country("Sweden", TimeZone.getTimeZone("Europe/Stockholm"));
//        entities.Airport airport1 = new entities.Airport("Copenhagen", "cph", country1);
//        entities.Airport airport2 = new entities.Airport("Stockholm", "arn", country2);
//        entities.Airline airline = new entities.Airline("SAS", "AS", new ArrayList<>());
//        airline.getFlightId().add(flight1);
//        airline.getFlightId().add(flight2);
//        entities.FlightInstance fi1 = new FlightInstance(flight1.getCapacity(), 200.0, "Monday", new Timestamp(10000l), new Timestamp(100000l), airport1, airport2, flight1);
//        entities.FlightInstance fi2 = new FlightInstance(flight1.getCapacity(), 200.0, "tuesdag", new Timestamp(100000000l), new Timestamp(100000000000l), airport2, airport1, flight1);
//        em.getTransaction().begin();
//        em.persist(flight1);
//        em.persist(flight2);
//        em.persist(country1);
//        em.persist(country2);
//        em.persist(airport1);
//        em.persist(airport2);
//        em.persist(fi1);
//        em.persist(fi2);
//        em.persist(airline);
//        em.getTransaction().commit();
//    }
//
//    public static void query(EntityManager em){
//        List<FlightInstance> t = FlightInstanceFactory.getByDateAndAirport(em,new Date(70, 0, 1), "Stockholm", "Copenhagen");
//        for (FlightInstance f: t) {
//            System.out.println(f.getId());
//            System.out.println(f.getSeats());
//            System.out.println(f.getOriginAirport().getName());
//        }
//    }
//}


