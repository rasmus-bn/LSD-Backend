package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "PNRIDENTIFIER")
public class PNRIdentifier {
    public PNRIdentifier() {
    }

    public PNRIdentifier(long pnr) {
        this.pnr = pnr;
    }

    @Id
    @Column(name = "ID")
    private long pnr;

    public contract.dto.PNRIdentifier toDto() {
        return new contract.dto.PNRIdentifier(this.pnr);
    }
}
