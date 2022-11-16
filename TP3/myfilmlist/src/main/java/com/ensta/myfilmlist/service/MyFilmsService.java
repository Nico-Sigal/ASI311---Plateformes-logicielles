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

      public default int calculerDureeTotale(List<Film> listeFilms) {
            int dureeTotale = 0;
            for(Film film : listeFilms) {dureeTotale += film.getDuree();}
            return dureeTotale;
      }

      public default int calculerNoteMoyenne(int a, int b) {
            int moyenne = 0;
            
            return moyenne;
      }
}
