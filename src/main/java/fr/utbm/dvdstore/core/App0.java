/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core;

import fr.utbm.dvdstore.core.util.HibernateUtil;

/**
 *
 * @author bonbo
 */
public class App0 {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}
