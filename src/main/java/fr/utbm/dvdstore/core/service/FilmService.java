/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.service;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.repository.FileFilmDao;

/**
 *
 * @author bonbo
 */
public class FilmService {
    public void registerFilm(Film f) {
        FileFilmDao fileFilmDao = new FileFilmDao();
        fileFilmDao.save(f);
    }
}
