/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Film;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bonbo
 */
public class FileFilmDao {
    public void save(Film f) {
        FileWriter writer;
        
        try {
            writer = new FileWriter("films.csv", true);
            writer.write(f.getTitre() + ";" + f.getGenre() + ";" + f.getNbExemplaires() + "\n");
            writer.close();
            System.out.println("Film enregistré avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'écriture dans le fichier !");
        }
    }
}
