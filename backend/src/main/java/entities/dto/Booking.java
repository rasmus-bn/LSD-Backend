package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "BOOKING")
public class Booking {

    public Booking(PNRIdentifier pnr, double price, FFNCCIdenitfier ffncc, Collection<Ticket> tickets,
                   FlightRoute flightRoute, FlightRoute returnRoute) {
        this.pnr = pnr;
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
    @Column(name = "ID")
    int id;

    @ManyToOne
    private PNRIdentifier pnr;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 200000)
    @Column(name = "PRICE")
    private double price;

    @ManyToOne
    private FFNCCIdenitfier ffncc;

    @OneToMany
    private Collection<Ticket> tickets;

    @ManyToOne
    private FlightRoute flightRoute;

    @ManyToOne
    private FlightRoute returnRoute;

    public contract.dto.Booking toDto() {
        Collection<contract.dto.Ticket> tmp = new ArrayList();
        for (Ticket t : this.tickets) {
            tmp.add(t.toDto());
        }
        return new contract.dto.Booking(
                this.pnr.toDto(),
                this.price,
                this.ffncc.toDto(),
                tmp, //TODO convert entity collection to dto collection
                this.flightRoute.toDto(),
                this.returnRoute.toDto());
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PNRIdentifier getPnr() {
        return pnr;
    }

    public void setPnr(PNRIdentifier pnr) {
        this.pnr = pnr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FFNCCIdenitfier getFfncc() {
        return ffncc;
    }

    public void setFfncc(FFNCCIdenitfier ffncc) {
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
