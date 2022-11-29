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

      public default double calculerNoteMoyenne(double[] notes) {
            float moyenne = 0;
            for (int compteur = 0; compteur < notes.length ; compteur++){moyenne += notes[compteur]/notes.length;}
            double moyennedeuxchiffres = (double) Math.round(moyenne*100)/100;
            return(moyennedeuxchiffres);
      }
}
