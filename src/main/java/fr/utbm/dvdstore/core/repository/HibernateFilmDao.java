/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Film;
import fr.utbm.dvdstore.core.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
                    System.out.println("\nSession terminée !\n");
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
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        return film;
    }
}
