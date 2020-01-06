package entities.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    public User() {
    }

    public User(int agencyNumber, String userName, String password) {
        this.agencyNumber = agencyNumber;
        this.userName = userName;
        this.password = password;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public void setAgencyNumber(int agencyNumber) {
        this.agencyNumber = agencyNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public contract.dto.User toDto() {
        return new contract.dto.User(this.userId,this.agencyNumber,this.userName,this.password);
    }
}