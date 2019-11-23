package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "PNRIDENTIFIER")
public class PNRIdentifier extends contract.dto.PNRIdentifier {
    public PNRIdentifier() {
    }

    public PNRIdentifier(long pnr) {
        super(pnr);
        this.pnr = pnr;
    }

    @Id
    @Column(name = "ID")
    private long pnr;
}
