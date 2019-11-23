package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table( name = "FLIGHTROUTE")
public class FlightRoute extends contract.dto.FlightRoute {
    public FlightRoute(boolean directFlight, Collection<contract.dto.Flight> flights) {
        super(directFlight, flights);
    }

    public FlightRoute() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "DIRECTFLIGHT")
    private boolean directFlight;

    @ManyToMany
    private Collection<Flight> flights;
}
