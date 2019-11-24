package entities.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FFNCIDENITFIER")
public class FFNCCIdenitfier {

    public FFNCCIdenitfier(String ffncc) {
        this.ffncc = ffncc;
    }

    public FFNCCIdenitfier() {
    }

    @Id
    @Column(name = "ID")
    private String ffncc;

    public FFNCCIdenitfier(contract.dto.FFNCCIdenitfier ffncc) {
        this.ffncc = ffncc.getFfcc();
    }

    public contract.dto.FFNCCIdenitfier toDto() {
        return new contract.dto.FFNCCIdenitfier(this.ffncc);
    }

    public String getFfncc() {
        return ffncc;
    }

    public void setFfncc(String ffncc) {
        this.ffncc = ffncc;
    }
}
