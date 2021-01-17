package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
import java.time.LocalDate;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Transaction {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column
    @NonNull
    private LocalDate venduLe;
    
    @Column
    @NonNull
    private Float prixVente;
    
    @ManyToOne
    private Exposition lieuDeVente;
    
    @ManyToOne
    private Personne client;
    
    @OneToOne
    private Tableau oeuvre;
}