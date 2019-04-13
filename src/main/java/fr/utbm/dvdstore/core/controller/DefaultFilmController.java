/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.controller;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.service.FilmService;
import java.util.Scanner;

/**
 *
 * @author bonbo
 */
public class DefaultFilmController {
    public void registerFilmFromConsoleInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Titre du film : ");
        String titre = sc.nextLine();
        System.out.print("Genre du film : ");
        String genre = sc.nextLine();
        System.out.print("Nombre d'exemplaires du film : ");
        int nbEx = sc.nextInt();
        
        Film film = new Film(titre, genre, nbEx);
        FilmService filmService = new FilmService();
        filmService.registerFilm(film);
    }
}
