package com.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Etudiant {
    private Integer id;
    private String nom;
    private String prenom;
    private String cne;
    private Filiere filiere;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "cne", nullable = false, length = 255)
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(id, etudiant.id) && Objects.equals(nom, etudiant.nom) && Objects.equals(prenom, etudiant.prenom) && Objects.equals(cne, etudiant.cne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, cne);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "filiere", referencedColumnName = "id", nullable = false)
    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
