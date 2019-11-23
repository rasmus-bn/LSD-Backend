package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "TICKET")
public class Ticket extends contract.dto.Ticket {
    public Ticket(contract.dto.Passenger passenger, contract.dto.Flight flight) {
        super(passenger, flight);
    }

    public Ticket() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @OneToOne
    @JoinColumn(name = "PASSENGERID")
    private Passenger passenger;

    @OneToOne
    @JoinColumn(name = "FLIGHTID")
    private Flight flight;

}
