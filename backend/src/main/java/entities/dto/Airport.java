package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

@Entity
@Table(name = "AIRPORT")
public class Airport extends contract.dto.Airport {


    public Airport(TimeZone timeZone, String iata, String name) {
        super(timeZone, iata, name);
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
    @Size(max = 10)
    @Column(name = "IATA")
    private String iata;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "NAME")
    private String name;

}
