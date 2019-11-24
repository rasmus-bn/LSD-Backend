package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FLIGHTOFFER")
public class FlightOffer extends contract.dto.FlightOffer{
    public FlightOffer(double price, boolean oneWay, FlightRoute outRoute, FlightRoute returnRoute) {
        super(price, oneWay, outRoute, returnRoute);
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
}
