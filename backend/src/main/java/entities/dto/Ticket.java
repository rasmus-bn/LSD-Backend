package entities.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TICKET")
public class Ticket implements Serializable {
    public Ticket(Passenger passenger, Flight flight) {
        this.flight = flight;
        this.passenger = passenger;
    }

    public Ticket() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "PASSENGERID")
    private Passenger passenger;

    @OneToOne
    @JoinColumn(name = "FLIGHTID")
    private Flight flight;

    public contract.dto.Ticket toDto() {
        return new contract.dto.Ticket(this.passenger.toDto(), this.flight.toDto());
    }
}
