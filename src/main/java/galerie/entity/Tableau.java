package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column(unique=true)
    @NonNull
    private String support;
    
    @Column
    @NonNull
    private Integer largeur;
    
    @Column
    @NonNull
    private Integer longueur;
    
    @ManyToMany(mappedBy = "oeuvres")
    List<Exposition> accrochages = new LinkedList<>();
    
    @OneToOne(mappedBy = "oeuvre")
    private Transaction vendu;
    
    @ManyToOne
    private Artiste auteur;
}
