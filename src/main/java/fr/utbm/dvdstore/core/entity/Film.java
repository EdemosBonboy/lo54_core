/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.entity;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author bonbo
 */
public class Film implements Serializable {
    private Integer id;
    private String titre;
    private String genre;
    private Integer nbExemplaires;
    private Acteur acteurPrincipal;
    private Set<Acteur> acteurs;
    
    public Film() { }

    public Film(String titre, String genre, Integer nbExemplaires) {
        this.titre = titre;
        this.genre = genre;
        this.nbExemplaires = nbExemplaires;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNbExemplaires() {
        return nbExemplaires;
    }

    public void setNbExemplaires(Integer nbExemplaires) {
        this.nbExemplaires = nbExemplaires;
    }

    public Acteur getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(Acteur acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "Film{" + "titre=" + titre + ", genre=" + genre + ", nbExemplaires=" + nbExemplaires + "}";
    }
}
