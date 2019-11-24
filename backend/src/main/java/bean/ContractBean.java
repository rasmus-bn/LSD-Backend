package bean;

import contract.dto.*;
import contract.interfaces.BeanInterface;
import logic.logicHandler;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.Date;

@Stateless
public class ContractBean implements BeanInterface {

    logicHandler lh = new logicHandler();

    @Resource
    private SessionContext context;

    @Override
    public User user(User user) {
        if(lh.authUser(user) == null){
            return null;
        }
        return lh.authUser(user);
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date start, Date end,
                                                   String depIata, String destIata, boolean oneWay) {
        if(lh.authUser(user) == null){
            return null;
        }
        return lh.getOffers(start, end, depIata, destIata, oneWay);
    }

    @Override
    public Booking makeBooking(User user, FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier,
                               Collection<Passenger> collection) {
        if(lh.authUser(user) == null){
            return null;
        }
        return lh.createBooking(flightOffer, ffnccIdenitfier, collection);
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnr) {
        if(lh.authUser(user) == null){
            return null;
        }
        return lh.getBookingByPNR(pnr);
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnr) {
        if(lh.authUser(user) == null){
            return false;
        }
        return lh.removeBookingByPNR(pnr);
    }

    @Override
    public String whoAmI(String s) {
        return "Hello, " + s + " I am backend!";
    }
}
