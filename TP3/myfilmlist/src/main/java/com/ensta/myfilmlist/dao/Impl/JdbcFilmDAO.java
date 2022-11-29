package com.ensta.myfilmlist.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

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
      private JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

      @Override
      public List<Film> findAll() {
            List<Film> listeFilms = new ArrayList<>();
                  Connection conn = dataSource.getConnection();
                  try (PreparedStatement statement = conn.prepareStatement(FIND_FILMS_QUERY))
                  {
                  ResultSet resultSet = statement.executeQuery();{
                  List<Object> listeFilms = 
                  jdbcTemplate.query(FIND_FILMS_QUERY, (resultSet, rownum) -> { Film film = new Film();
                  film.setId(resultSet.getInt("id"));
                        film.setTitre(resultSet.getString("titre"));
                        film.setDuree(resultSet.getInt("duree"));
                        return film;});
                  }
            }
      return listeFilms;
      }
}