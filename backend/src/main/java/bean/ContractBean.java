package bean;

import contract.dto.*;
import contract.interfaces.BeanInterface;

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
    private EntityManager em;
    private logic.Flights f = new logic.Flights();
    private logic.Booking b = new logic.Booking();

    public ContractBean() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        this.em = emf.createEntityManager();
    }

    @Resource
    private SessionContext context;

    @Override
    public User user(User user) {
        return null;
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date start, Date end,
                                                   String depIata, String destIata, boolean oneWay) {
        return f.getOffers(user, start, end, depIata, destIata, oneWay);
    }

    @Override
    public Booking makeBooking(User user, FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier,
                               Collection<Passenger> collection) {
        return b.createBooking(em, flightOffer, ffnccIdenitfier, collection);
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnr) {
        return b.getBookingByPNR(em, pnr);
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnr) {
        return b.removeBookingByPNR(em, pnr);
    }

    @Override
    public String whoAmI(String s) {
        return "Hello, " + s + " I am backend!";
    }
}
