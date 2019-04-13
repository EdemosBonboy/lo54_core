/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Film;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bonbo
 */
public class JdbcFilmDao {
    public void save(Film f) {
        //saveStatement(f);
        
        savePrepareStatement(f);
    }
    
    public void saveStatement(Film f) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            System.out.println("Connection OK !");
            
            Statement stmt = con.createStatement();
            String query = "INSERT INTO MOVIE(TITLE, MOVIE_TYPE, COPIES) VALUES ('" + f.getTitre() + "', '" + f.getGenre() + "', " + f.getNbExemplaires() + ")";
            int nb = stmt.executeUpdate(query);
            System.out.println(nb + " new film added (saveStatement) !");
        } catch (Throwable e) {
            System.out.println("Connection KO");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public void savePrepareStatement(Film f) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            System.out.println("Connection OK !");
            
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO MOVIE(TITLE, MOVIE_TYPE, COPIES) "
                                                         + "VALUES (?, ?, ?)");
            pstmt.setString(1, f.getTitre());
            pstmt.setString(2, f.getGenre());
            pstmt.setInt(3, f.getNbExemplaires());
            int nb = pstmt.executeUpdate();
            System.out.println(nb + " new film added (savePrepareStatement) !");
        } catch (Throwable e) {
            System.out.println("Connection KO");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public ArrayList<Film> listFilms() {
        ArrayList<Film> films = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/video", "video", "video");
            System.out.println("Connection OK !");
            
            Statement stmt = con.createStatement();
            String query = "SELECT TITLE, MOVIE_TYPE, COPIES FROM MOVIE";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                String titre = resultSet.getString("TITLE");
                String genre = resultSet.getString("MOVIE_TYPE");
                int nbEx = resultSet.getInt("COPIES");
                films.add(new Film(titre, genre, nbEx));
            }
        } catch (Throwable e) {
            System.out.println("Connection KO");
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return films;
    }
}
