package entities.dto;

import contract.dto.Flight;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FLIGHTOFFER")
public class FlightOffer {
    public FlightOffer(double price, boolean oneWay, FlightRoute outRoute, FlightRoute returnRoute) {
        this.price = price;
        this.oneWay = oneWay;
        this.outRoute = outRoute;
        this.returnRoute = returnRoute;
    }

    public FlightOffer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 200000)
    @Column(name = "PRICE")
    private double price;

    @NotNull
    @Basic(optional = false)
    @Column(name = "ONEWAY")
    private boolean oneWay;

    @ManyToOne
    private FlightRoute outRoute;

    @ManyToOne
    private FlightRoute returnRoute;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public void setOneWay(boolean oneWay) {
        this.oneWay = oneWay;
    }

    public FlightRoute getOutRoute() {
        return outRoute;
    }

    public void setOutRoute(FlightRoute outRoute) {
        this.outRoute = outRoute;
    }

    public FlightRoute getReturnRoute() {
        return returnRoute;
    }

    public void setReturnRoute(FlightRoute returnRoute) {
        this.returnRoute = returnRoute;
    }

    public contract.dto.FlightOffer toDto(){
        return new contract.dto.FlightOffer(this.price, this.oneWay, this.outRoute.toDto(), this.returnRoute.toDto());
    }
}
