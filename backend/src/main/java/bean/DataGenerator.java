package bean;

import contract.dto.*;

import java.awt.print.Book;
import java.util.*;

public class DataGenerator {
    public static User genUser() {
        return new  User(1, 1234, "Mo","123" );
    }

    public static Flight[] genFlights() {
        Flight[] flights = new Flight[4];
        flights[0] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "SKF"),
                new Airport(TimeZone.getTimeZone("GMT"), "CPH", "Copenhagen"),
                new Airport(TimeZone.getTimeZone("GMT"), "NY", "New York")
        );
        flights[1] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "KOD"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLM", "Malmø"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLG", "Malaga")
        );
        flights[2] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "KSF"),
                new Airport(TimeZone.getTimeZone("GMT"), "BAR", "Barcelona"),
                new Airport(TimeZone.getTimeZone("GMT"), "REY", "Reykjavik")
        );
        flights[3] = new Flight(
                1L,
                new Date(),
                new Date(),
                new Airplane(7, "MIU"),
                new Airport(TimeZone.getTimeZone("GMT"), "MLG", "Malaga"),
                new Airport(TimeZone.getTimeZone("GMT"), "BIL", "Billund")
        );

        return flights;
    }

    public static FlightRoute[] genFlightRoutes() {
        Flight[] flights = genFlights();

        FlightRoute[] routes = new FlightRoute[3];

        ArrayList<Flight> flight1 = new ArrayList<>();
        flight1.add(flights[0]);
        routes[0] = new FlightRoute(true, flight1);
        //new rout from Barcelona to Malmø
        ArrayList<Flight> flight2 = new ArrayList<>();
        flight2.add(flights[1]);
        flight2.add(flights[2]);
        routes[1] = new FlightRoute(false, flight2);
        //new rout
        ArrayList<Flight> flight3 = new ArrayList<>();
        flight3.add(flights[2]);
        routes[2] = new FlightRoute(true, flight3);
        return routes;
    }

    public static FlightOffer[] genFlightOffers(boolean oneWay) {
        FlightOffer[] offers = new FlightOffer[4];
        FlightRoute[] routes = genFlightRoutes();
        offers[0] = new FlightOffer(3333.2, false, routes[1], routes[0]);
        System.out.println(offers[0]);
        offers[1] = new FlightOffer(11341.1, true, routes[2], routes[0]);
        offers[2] = new FlightOffer(123300.2, true, routes[0], routes[2]);
        offers[3] = new FlightOffer(19938.90, false, routes[2], routes[1]);
        for (FlightOffer o : offers) {
            o.setOneWay(oneWay);
            if (oneWay) o.setReturnRoute(null);
        }
        return offers;
    }

    public static ArrayList<FlightOffer> genFlightOffersAList(boolean oneWay){
        return new ArrayList<>(Arrays.asList(DataGenerator.genFlightOffers(oneWay)));
    }

    public static ArrayList<Passenger> getPassengers(int start, int end) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger("Mikkel", "Hansen", new Date(1999, 06, 30)));
        passengers.add(new Passenger("Jonas", "Møller", new Date(1991, 06, 30)));
        passengers.add(new Passenger("Bob", "McScmidt", new Date(1990, 06, 30)));
        passengers.add(new Passenger("John", "Trianson", new Date(1994, 06, 30)));
        passengers.add(new Passenger("Davy", "Jones", new Date(1998, 06, 30)));
        ArrayList<Passenger> rPassengers = new ArrayList<>();
        for (int i = start; i <= end && i < passengers.size(); i++) {
            rPassengers.add(passengers.get(i));
        }
        return rPassengers;
    }

    public static PNRIdentifier getPnr(long l) {
        return new PNRIdentifier(l);
    }
    public static FFNCCIdenitfier getFfnCc(String s) {
        return new FFNCCIdenitfier(s);
    }

    public static Booking genBooking(){
        FlightRoute[] flightroutes = genFlightRoutes();
        ArrayList<Passenger> passengers = getPassengers(1,1);
        ArrayList<Ticket> tickets = getTickets(passengers, flightroutes[0]);
        Booking booking = new Booking(getPnr(1), 2000.00, getFfnCc("2000102323"), tickets, flightroutes[0], flightroutes[1]);
        return booking;
    }

    public static ArrayList<Ticket> getTickets(ArrayList<Passenger> passengers, FlightRoute route) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (Flight f : route.getFlights()) {
            for (Passenger p : passengers) {
                tickets.add(new Ticket(p, f));
            }
        }
        return tickets;
    }

    public static ArrayList<Booking> getBookings() {
        ArrayList<Booking> bookings = new ArrayList<>();

        FlightRoute[] flightroutes = genFlightRoutes();
        ArrayList<Passenger> passengers = getPassengers(0,0);
        ArrayList<Ticket> tickets = getTickets(passengers, flightroutes[0]);
        System.out.println("Passengar size: " + passengers.size());
        System.out.println("Ticket size: " + tickets.size());
        bookings.add(new Booking(getPnr(1), 2400.00, getFfnCc("2000102323"), tickets, flightroutes[0], flightroutes[1]));

        passengers = getPassengers(2,6);
        tickets = getTickets(passengers, flightroutes[2]);
        System.out.println("Passengar size: " + passengers.size());
        System.out.println("Ticket size: " + tickets.size());
        bookings.add(new Booking(getPnr(2), 5000.00, getFfnCc("12342345552"), tickets, flightroutes[2], flightroutes[0]));

        passengers = getPassengers(3,4);
        tickets = getTickets(passengers, flightroutes[1]);
        System.out.println("Passengar size: " + passengers.size());
        System.out.println("Ticket size: " + tickets.size());
        bookings.add(new Booking(getPnr(3), 1500.00, getFfnCc("3654462323"), tickets, flightroutes[1], flightroutes[2]));

        passengers = getPassengers(0,6);
        tickets = getTickets(passengers, flightroutes[0]);
        System.out.println("Passengar size: " + passengers.size());
        System.out.println("Ticket size: " + tickets.size());
        bookings.add(new Booking(getPnr(4), 800.00, getFfnCc("34569696312"), tickets, flightroutes[0], flightroutes[1]));

        return bookings;
    }
}