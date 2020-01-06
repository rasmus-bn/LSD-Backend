package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "AIRPLANE")
public class Airplane implements Serializable {

    public Airplane() {
    }

    public Airplane(@NotNull @Size(min = 1, max = 2000) int capacity, @Size(max = 4) String iata) {
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

    public Airplane(contract.dto.Airplane airplane) {
        this.capacity = airplane.getCapacity();
        this.iata = airplane.getIata();
    }

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

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public contract.dto.Airplane toDto() {
        return new contract.dto.Airplane(this.capacity, this.iata);
    }
}
