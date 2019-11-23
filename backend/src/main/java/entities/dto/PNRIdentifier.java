package entities.dto;

import javax.persistence.*;

@Entity
@Table(name = "PNRIDENTIFIER")
public class PNRIdentifier extends contract.dto.PNRIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long pnr;
}
