package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;

public interface MyFilmsService {
      
      /**
       * @param realisateur
       * @return realisateur updaté
       * @throws ServiceException
       */
      public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException;

      public int calculerDureeTotale(List<Film> listeFilms);

      public double calculerNoteMoyenne(double[] notes);
}
