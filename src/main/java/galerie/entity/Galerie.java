package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "galerie")
    private List<Exposition> events = new LinkedList<>();
    
    public float caAnnuel(int annee) {
        float chiffreAffaire = 0;
        for (Exposition e : events) {
            if (e.getDebut().getYear() == annee) {
                chiffreAffaire += e.ca();
            }
        }
        return chiffreAffaire;
    }
}
