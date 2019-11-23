package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "PNRIDENTIFIER")
public class PNRIdentifier extends contract.dto.PNRIdentifier {
    public PNRIdentifier() {
    }

    public PNRIdentifier(long pnr) {
        super(pnr);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long pnr;
}
