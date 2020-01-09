package bean;

import contract.dto.*;
import contract.interfaces.BeanInterface;
import javax.ejb.Stateless;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Stateless
public class ContractBean implements BeanInterface {
    private final User SIUSER = new User(55, 33, "sgd-B2C", "sgd-B2C-pw");

    private boolean login(User user) {
        if (!user.getUserName().equals(SIUSER.getUserName()))
            return false;
        if (user.getAgencyNumber() != SIUSER.getAgencyNumber())
            return false;
        if (!user.getPassword().equals(SIUSER.getPassword()))
            return false;
        return true;
    }


    @Override
    public User user(User user) {
        if (!login(user)) return null;
        return SIUSER;
    }

    @Override
    public Collection<FlightOffer> getFlightOffers(User user, Date date, Date date1, String s, String s1, boolean b) {
        if (!login(user)) return null;
        return null;
    }

    @Override
    public Booking makeBooking(User user, FlightOffer flightOffer, FFNCCIdenitfier ffnccIdenitfier, Collection<Passenger> collection) {
        if (!login(user)) return null;
        return null;
    }

    @Override
    public Booking getBooking(User user, PNRIdentifier pnrIdentifier) {
        if (!login(user)) return null;

        for (Booking booking : DataGenerator.getBookings()) {
            if (booking.getPnr().getPnr() == pnrIdentifier.getPnr()) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public boolean cancelBooking(User user, PNRIdentifier pnrIdentifier) {
        if (!login(user)) return false;
        return false;
    }

    @Override
    public String whoAmI(String s) {
        return "Hello, " + s + " I am backend!";
    }
}
