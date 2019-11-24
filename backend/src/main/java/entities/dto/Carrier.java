package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CARRIER")
public class Carrier {
    public Carrier(@NotNull @Size(min = 1, max = 2000) String name, @NotNull @Size(min = 0, max = 10) String iata) {
        this.name = name;
        this.iata = iata;
    }

    public Carrier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "NAME")
    @NotNull
    @Size(min = 1, max = 2000)
    private String name;

    @Column(name = "IATA")
    @NotNull
    @Size(min = 0, max = 10)
    private String iata;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }
}
