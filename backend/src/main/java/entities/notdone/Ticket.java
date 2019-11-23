package entities.notdone;

import entities.dto.Flight;
import entities.dto.Passenger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ticket extends contract.dto.Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    private Passenger passenger;
    private Flight flight;

}
