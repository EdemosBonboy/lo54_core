/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author bonbo
 */
public class HibernateFilmDao {
    public void save(Film f) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(f);
            session.getTransaction().commit();
            
            System.out.println("Enregistrement effectué avec succès !");
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                    System.out.println("Enregistrement annulé !");
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he3) {
                    he3.printStackTrace();
                }
            }
        }
    }
    
    public Film detailsFilm(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Film film = null;
        try {
            session.beginTransaction();
            film = (Film) session.get(Film.class, id);
            Hibernate.initialize(film.getActeurPrincipal());
            Hibernate.initialize(film.getActeurs());
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        return film;
    }
    
    public List<Film> listFilms() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Film");
            films = query.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                    StandardServiceRegistryBuilder.destroy(session.getSessionFactory().getSessionFactoryOptions().getServiceRegistry());
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        
        return films;
    }
}
