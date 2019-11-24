package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
    public Passenger(String firstName, String lastName, Date dob) {
        this.dob = dob;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Passenger() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FRISTNAME")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LASTNAME")
    private String lastName;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEOFBIRTH")
    private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public contract.dto.Passenger toDto() {
        return new contract.dto.Passenger(this.firstName, this.lastName, this.dob);
    }
}
