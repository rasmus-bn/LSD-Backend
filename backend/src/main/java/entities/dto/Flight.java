package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight extends contract.dto.Flight {
    public Flight(long id, Date depDate, Date arrDate, Airplane airplane, Airport depAirport, Airport arrAirport) {
        super(id, depDate, arrDate, airplane, depAirport, arrAirport);
        this.depDate = depDate;
        this.arrDate = arrDate;
        this.airplane =  airplane;
        this.depAirport =  depAirport;
        this.arrAirport =  arrAirport;
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
