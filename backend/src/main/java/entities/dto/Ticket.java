package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "TICKET")
public class Ticket {

    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
