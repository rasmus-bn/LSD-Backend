package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "BOOKING")
public class Booking extends contract.dto.Booking {

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

}
