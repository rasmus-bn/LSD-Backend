package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AIRPLANE")
public class Airplane extends contract.dto.Airplane {

    public Airplane() {
        super(0,null);
    }

    public Airplane(@NotNull @Size(min = 1, max = 2000) int capacity, @Size(max = 4) String iata) {
        super(capacity, iata);
        this.capacity = capacity;
        this.iata = iata;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 2000)
    @Column(name = "CAPACITY")
    private int capacity;

    @Basic(optional = false)
    @Size(max = 4)
    @Column(name = "IATA")
    private String iata; // number of the carrier

}
