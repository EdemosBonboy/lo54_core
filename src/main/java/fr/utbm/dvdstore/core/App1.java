/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core;

import fr.utbm.dvdstore.core.controller.DefaultFilmController;
import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.service.FilmService;

/**
 *
 * @author bonbo
 */
public class App1 {
    public static void main(String[] args) {
        DefaultFilmController defaultFilmController = new DefaultFilmController();
        defaultFilmController.registerFilmFromConsoleInput();
    }
}
