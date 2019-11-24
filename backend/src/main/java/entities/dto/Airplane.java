package entities.dto;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AIRPLANE")
public class Airplane {

    public Airplane() {
    }

    public Airplane(@NotNull @Size(min = 1, max = 2000) int capacity, @NotNull Carrier carrier) {
        this.capacity = capacity;
        this.carrier = carrier;
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

   /* @Basic(optional = false)
    @Size(max = 4)
    @Column(name = "IATA")
    private String iata; */ // number of the carrier

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CARRIER")
    private Carrier carrier;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

}
