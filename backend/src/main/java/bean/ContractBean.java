package bean;

import contract.dto.*;
import contract.interfaces.BeanInterface;
import logic.Flights;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Date;

@Stateless
public class ContractBean implements BeanInterface {
    Flights f = new Flights();

    @Resource
    private SessionContext context;

    @Override
    public User user(User user) {
        return null;
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date start, Date end, String depIata, String destIata, boolean oneWay) {
        return f.getOffers(user, start, end, depIata, destIata, oneWay);
    }

    @Override
    public Booking makeBooking(User user, FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier, Collection<Passenger> collection) {
        return null;
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnrIdentifier) {
        return null;
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnrIdentifier) {
        return false;
    }

    @Override
    public String whoAmI(String s) {
        return "Hello, " + s + " I am backend!";
    }
}
