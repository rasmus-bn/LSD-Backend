package bean;

import contract.dto.*;
import contract.interfaces.BeanInterface;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Date;

@Stateless
public class ContractBean implements BeanInterface {

    @Resource
    private SessionContext context;

    @Override
    public User user(User user) {
        return null;
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date date, Date date1, String s, String s1, boolean b) {
        return null;
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
