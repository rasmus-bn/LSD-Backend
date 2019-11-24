package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

@Entity
@Table(name = "AIRPORT")
public class Airport {


    public Airport(TimeZone timeZone, String iata, String name) {
        this.timeZone = timeZone;
        this.iata = iata;
        this.name = name;
    }

    public Airport() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "TIMEZONE")
    private TimeZone timeZone;

    @Basic(optional = false)
    @NotNull
    @Size(max = 3)
    @Column(name = "IATA")
    private String iata;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "NAME")
    private String name;

    public Airport(contract.dto.Airport a) {
        this.iata = a.getIata();
        this.name = a.getName();
        this.timeZone = a.getTimeZone();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public contract.dto.Airport toDto() {
        return new contract.dto.Airport(this.timeZone, this.iata, this.name);
    }
}
