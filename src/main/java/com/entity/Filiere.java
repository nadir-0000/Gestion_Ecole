package com.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Filiere {
    private Integer id;
    private String code;
    private String libelle;
    private Collection<Etudiant> etudiants;

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
    @Column(name = "code", nullable = false, length = 255)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "libelle", nullable = false, length = 255)
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filiere filiere = (Filiere) o;
        return Objects.equals(id, filiere.id) && Objects.equals(code, filiere.code) && Objects.equals(libelle, filiere.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, libelle);
    }

    @OneToMany(mappedBy = "filiere")
    public Collection<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Collection<Etudiant> etudiantsById) {
        this.etudiants = etudiantsById;
    }
}
