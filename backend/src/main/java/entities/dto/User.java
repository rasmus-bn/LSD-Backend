package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User extends contract.dto.User {
    public User(int userId, int agencyNumber, String userName, String password) {
        super(userId, agencyNumber, userName, password);
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int userId;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 2000)
    @Column(name = "AGENCYNUMBER")
    int agencyNumber;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 2000)
    @Column(name = "USERNAME")
    String userName;

    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "PASSWORD")
    String password;


}