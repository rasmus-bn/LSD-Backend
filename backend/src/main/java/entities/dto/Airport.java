package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.TimeZone;

@Entity
@Table(name = "AIRPORT")
public class Airport extends contract.dto.Airport {


    public Airport(@NotNull @Size(min = 1, max = 2000) TimeZone timeZone, @NotNull @Size(max = 3) String iata, @NotNull @Size(min = 1, max = 2000) String name) {
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
    @Size(max = 3)
    @Column(name = "IATA")
    private String iata;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "NAME")
    private String name;

}
