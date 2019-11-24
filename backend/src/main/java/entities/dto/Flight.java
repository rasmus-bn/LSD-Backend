package entities.dto;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight{

    public Flight(@NotNull Date depDate, @NotNull Date arrDate, Airplane airplane, Airport depAirport, Airport arrAirport, @NotNull Carrier carrier) {
        this.depDate = depDate;
        this.arrDate = arrDate;
        this.airplane = airplane;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.carrier = carrier;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "AIRPLANEID")
    private Airplane airplane;

    @OneToOne
    @JoinColumn(name = "DEPARTUREAIRPORT")
    private Airport depAirport;

    @OneToOne
    @JoinColumn(name = "ARRIVALAIRPORT")
    private Airport arrAirport;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "CARRIER")
    private Carrier carrier;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Date getArrDate() {
        return arrDate;
    }

    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(Airport depAirport) {
        this.depAirport = depAirport;
    }

    public Airport getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(Airport arrAirport) {
        this.arrAirport = arrAirport;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}
