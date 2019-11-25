package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "BOOKING")
public class Booking {

    public Booking(double price, String ffncc, Collection<Ticket> tickets,
                   FlightRoute flightRoute, FlightRoute returnRoute) {
        this.price = price;
        this.ffncc = ffncc;
        this.tickets = tickets;
        this.flightRoute = flightRoute;
        this.returnRoute = returnRoute;

    }

    public Booking() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PNR")
    private long pnr;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 200000)
    @Column(name = "PRICE")
    private double price;

    @NotNull
    @Basic(optional = false)
    @Column(name = "FFNCC")
    private String ffncc;

    @OneToMany (cascade = CascadeType.ALL)
    private Collection<Ticket> tickets;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private FlightRoute flightRoute;

    @ManyToOne (cascade = CascadeType.PERSIST)
    private FlightRoute returnRoute;

    public contract.dto.Booking toDto() {
        Collection<contract.dto.Ticket> tmp = new ArrayList();
        for (Ticket t : this.tickets) {
            tmp.add(t.toDto());
        }
        return new contract.dto.Booking(
                new contract.dto.PNRIdentifier(this.pnr),
                this.price,
                new contract.dto.FFNCCIdenitfier(this.ffncc),
                tmp,
                this.flightRoute.toDto(),
                this.returnRoute.toDto());
        }

    public long getPnr() {
        return pnr;
    }

    public void setPnr(long pnr) {
        this.pnr = pnr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFfncc() {
        return ffncc;
    }

    public void setFfncc(String ffncc) {
        this.ffncc = ffncc;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public FlightRoute getFlightRoute() {
        return flightRoute;
    }

    public void setFlightRoute(FlightRoute flightRoute) {
        this.flightRoute = flightRoute;
    }

    public FlightRoute getReturnRoute() {
        return returnRoute;
    }

    public void setReturnRoute(FlightRoute returnRoute) {
        this.returnRoute = returnRoute;
    }
}
