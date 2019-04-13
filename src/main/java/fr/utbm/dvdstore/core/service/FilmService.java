/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.service;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.repository.FileFilmDao;
import fr.utbm.dvdstore.core.repository.JdbcFilmDao;
import java.util.ArrayList;

/**
 *
 * @author bonbo
 */
public class FilmService {
    public void registerFilm(Film f) {
        //FileFilmDao fileFilmDao = new FileFilmDao();
        //fileFilmDao.save(f);
        
        JdbcFilmDao jdbcFilmDao = new JdbcFilmDao();
        jdbcFilmDao.save(f);
    }
    
    public void getAllFilms() {
        JdbcFilmDao jdbcFilmDao = new JdbcFilmDao();
        FileFilmDao fileFilmDao = new FileFilmDao();
        
        ArrayList<Film> films = jdbcFilmDao.listFilms();
        System.out.println("Nb films : " + films.size());
        for (Film f : films) {
            System.out.println(f.toString());
            fileFilmDao.save(f);
        }
    }
}
