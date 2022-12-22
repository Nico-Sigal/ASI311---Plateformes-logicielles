package com.ensta.myfilmlist.service;

import java.security.Provider.Service;
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

      /**
       * @param listeFilms : liste des films dont on calcule la durée totale, liste supposée non nulle de films non nuls
       * @return duree totale : entier représentant la somme des durées des films de la liste
       * @throws ServiceException : exception de type "Service" en cas de disfonctionnement de la fonction
       */
      public int calculerDureeTotale(List<Film> listeFilms) throws ServiceException;

      /**
       * @param notes : tableau de décimal non nul contenant les notes des films
       * @return note moyenne : décimal à deux chiffres après la virgule représentant la moyenne des notes données en paramètre
       * @throws ServiceException : exception de type "Service" en cas de disfonctionnement de la fonction
       */
      public double calculerNoteMoyenne(double[] notes) throws ServiceException;

      /**
       * @return liste des films : liste de tous les films en base de données
       * @throws ServiceException : exception de type "Service" en cas de disfonctionnement de la fonction
       */
      public List<FilmDTO> findAllFilms() throws ServiceException;
}
