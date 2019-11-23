package entities.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FFNCIDENITFIER")
public class FFNCCIdenitfier extends contract.dto.FFNCCIdenitfier {

    @Id
    @Column(name = "ID")
    private String ffcc;
}
