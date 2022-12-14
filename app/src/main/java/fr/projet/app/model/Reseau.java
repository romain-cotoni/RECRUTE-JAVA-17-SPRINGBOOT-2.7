package fr.projet.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "reseau")
public class Reseau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_res", nullable = false)
    private Integer idReseau;

    @Column(name="reseau_res", length=50)
    private String reseau;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "reseau", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Pseudo> pseudos = new HashSet<Pseudo>();

    public Reseau()
    {

    }

    public Reseau(String reseau, Set<Pseudo> pseudos)
    {
        this.reseau = reseau;
        this.pseudos = pseudos;
    }

    public Integer getIdReseau() {
        return idReseau;
    }


    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public Set<Pseudo> getPseudos() {
        return pseudos;
    }

    public void setPseudos(Set<Pseudo> pseudos) {
        this.pseudos = pseudos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reseau reseau1 = (Reseau) o;
        return Objects.equals(reseau, reseau1.reseau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reseau);
    }
}