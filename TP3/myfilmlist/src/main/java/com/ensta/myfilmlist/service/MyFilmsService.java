package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;

public interface MyFilmsService {
      
      /**
       * @param realisateur : réalisateur supposé non nul
       * @return realisateur updaté : réalisateur dont le statut célèbre a été mis à jour par la fonction
       * @throws ServiceException : exception de type "Service" en cas de disfonctionnement de la fonction
       */
      public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException;

      public int calculerDureeTotale(List<Film> listeFilms);

      public double calculerNoteMoyenne(double[] notes);

      public List<FilmDTO> findAllFilms();
}
