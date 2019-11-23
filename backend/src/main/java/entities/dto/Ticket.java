package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "TICKET")
public class Ticket extends contract.dto.Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @OneToOne
    @Column(name = "PASSENGERID")
    private Passenger passenger;

    @OneToOne
    @Column(name = "FLIGHTID")
    private Flight flight;

}
