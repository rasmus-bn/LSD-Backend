package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight extends contract.dto.Flight {
    public Flight(long id, Date depDate, Date arrDate, contract.dto.Airplane airplane, contract.dto.Airport depAirport, contract.dto.Airport arrAirport) {
        super(id, depDate, arrDate, airplane, depAirport, arrAirport);
    }

    public Flight() {
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEPARTUREDATE")
    private Date depDate;

    @NotNull
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARRIVALDATE")
    private Date arrDate;

    @OneToOne
    @JoinColumn(name = "AIRPLANEID")
    private Airplane airplane;

    @OneToOne
    @JoinColumn(name = "DEPARTUREAIRPORT")
    private Airport depAirport;

    @OneToOne
    @JoinColumn(name = "ARRIVALAIRPORT")
    private Airport arrAirport;

}
