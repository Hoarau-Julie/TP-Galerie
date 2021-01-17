package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "client")
    private List<Transaction> achats;
    
    public float budgetArtAnnuel(int annee) {
        float budget = 0;
        for (Transaction t : achats) {
            if (t.getVenduLe().getYear() == annee) {
                budget += t.getPrixVente();
            }
        }
        return budget;
    }
}
