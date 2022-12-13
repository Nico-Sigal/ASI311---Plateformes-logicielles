package com.ensta.myfilmlist.dao.Impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.persistence.ConnectionManager;

public class JdbcFilmDAO implements FilmDAO {

      private JdbcTemplate jdbcTemplate = ConnectionManager.getJdbcTemplate();

      private static FilmDAO instance;

      public static FilmDAO getInstance(){
            if (instance == null){
                  instance = new JdbcFilmDAO();}
            return instance;
      }

      private static final String FIND_FILMS_QUERY = "SELECT id, titre, duree FROM Film";

      @Override
      public List<Film> findAll() {
            System.out.println("méthode findAll utilisée ici");
            return jdbcTemplate.query(FIND_FILMS_QUERY, (resultSet,index) -> {
                  Film film = new Film();
                  film.setId(resultSet.getInt("id"));
                  film.setTitre(resultSet.getString("titre"));
                  film.setDuree(resultSet.getInt("duree"));
                  return film;
            }
            );
      }

}