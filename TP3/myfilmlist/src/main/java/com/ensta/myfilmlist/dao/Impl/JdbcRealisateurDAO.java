package com.ensta.myfilmlist.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.model.Realisateur;

@Repository
public class JdbcRealisateurDAO implements RealisateurDAO {

      @Autowired
      private JdbcTemplate jdbcTemplate;

      private static final String FIND_REALISATEURS_QUERY = "SELECT id, nom, prenom, dateNaissance, filmsRealises, celebre FROM Realisateur";

      @Override
      public List<Realisateur> findAll() {
            return jdbcTemplate.query(FIND_REALISATEURS_QUERY, (resultSet,index) -> {
                  Realisateur realisateur = new Realisateur();
                  realisateur.setId(resultSet.getInt("id"));
                  realisateur.setNom(resultSet.getString("nom"));
                  realisateur.setPrenom(resultSet.getString("prenom"));
                  realisateur.setDateNaissance(resultSet.getDate("dateNaissance").toLocalDate());
                  //realisateur.setFilmRealises(resultSet.getList<Film>("filmsRealises"));
                  realisateur.setCelebre(resultSet.getBoolean("celebre"));
                  return realisateur;
            }
            );
      }

      @Override
      public Realisateur findByNomAndPrenom(String nom, String prenom) {
            return null;
      }
      
}
