package com.ensta.myfilmlist.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.persistence.ConnectionManager;

public class JdbcFilmDAO implements FilmDAO {

      private DataSource dataSource = ConnectionManager.getDataSource();

      private static FilmDAO instance;

      public static FilmDAO getInstance(){
            if (instance == null){instance = new JdbcFilmDAO();}
            return instance;
            }

      private static final String FIND_FILMS_QUERY = "SELECT id, titre, duree FROM Film";

      @Override
      public List<Film> findAll() {
            List<Film> listeFilms = new ArrayList<>();
            try (
                  Connection conn = dataSource.getConnection();
                  PreparedStatement statement = conn.prepareStatement(FIND_FILMS_QUERY);
            ) {
                  try (ResultSet resultSet = statement.executeQuery()){
                        while (resultSet.next()) {
                        Film film = new Film();
                        film.setId(resultSet.getInt("id"));
                        film.setTitre(resultSet.getString("titre"));
                        film.setDuree(resultSet.getInt("duree"));
                        listeFilms.add(film);
                        }
                  }
            } catch (SQLException e) {
                  System.out.println(e);}
            return listeFilms;
      }

}