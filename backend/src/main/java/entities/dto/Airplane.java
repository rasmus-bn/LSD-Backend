package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AIRPLANE")
public class Airplane extends contract.dto.Airplane {

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
