/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.service;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.repository.FileFilmDao;
import fr.utbm.dvdstore.core.repository.HibernateFilmDao;
import fr.utbm.dvdstore.core.repository.JdbcFilmDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bonbo
 */
public class FilmService {
    public void registerFilm(Film f) {
        //FileFilmDao fileFilmDao = new FileFilmDao();
        //fileFilmDao.save(f);
        
        //JdbcFilmDao jdbcFilmDao = new JdbcFilmDao();
        //jdbcFilmDao.save(f);
        
        HibernateFilmDao hibernateFilmDao = new HibernateFilmDao();
        hibernateFilmDao.save(f);
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
    
    public void detailsFilm(int id) {
        HibernateFilmDao hibernateFilmDao = new HibernateFilmDao();
        Film film =  hibernateFilmDao.detailsFilm(id);
        if (film != null) {
            System.out.println("Film trouvé !");
            System.out.println(film.toString());
        } else {
            System.out.println("Aucun film trouvé avec l'identifiant " + id);
        }
    }
    
    public void listFilmsFromHibernate() {
        HibernateFilmDao hibernateFilmDao = new HibernateFilmDao();
        List<Film> films = hibernateFilmDao.listFilms();
        if (films != null && films.size() > 0) {
            System.out.println(films.size() + " films trouvés !");
            for (Film f : films) {
                System.out.println("Titre : " + f.getTitre());
            }
        } else {
            System.out.println("Aucun film trouvé !");
        }
    }
}
