package com.ensta.myfilmlist.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.model.Film;

@Repository
public class JdbcFilmDAO implements FilmDAO {

      @Autowired
      private JdbcTemplate jdbcTemplate;

      private static final String FIND_FILMS_QUERY = "SELECT id, titre, duree FROM Film";

      @Override
      public List<Film> findAll() {
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