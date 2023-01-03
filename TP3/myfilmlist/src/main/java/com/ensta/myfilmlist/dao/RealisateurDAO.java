package com.ensta.myfilmlist.dao;

import java.util.List;

import com.ensta.myfilmlist.model.Realisateur;

public interface RealisateurDAO {
      public List<Realisateur> findAll();

      public Realisateur findByNomAndPrenom(String nom, String prenom);
}
