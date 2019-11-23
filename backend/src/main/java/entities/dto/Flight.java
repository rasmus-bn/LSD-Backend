package entities.dto;

import entities.dto.Airplane;
import entities.dto.Airport;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight extends contract.dto.Flight {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "DEPARTUREDATE")
    private Date depDate;

    @NotNull
    @Basic(optional = false)
    @Column(name = "ARRIVALDATE")
    private Date arrDate;

    @OneToOne
    @Column(name = "AIRPLANEID")
    private Airplane airplane;

    @OneToOne
    @Column(name = "DEPARTUREAIRPORT")
    private Airport depAirport;

    @OneToOne
    @Column(name = "ARRIVALAIRPORT")
    private Airport arrAirport;

}
