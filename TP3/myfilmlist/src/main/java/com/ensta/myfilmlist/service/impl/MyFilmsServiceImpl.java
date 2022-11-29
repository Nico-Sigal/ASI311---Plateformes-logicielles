package com.ensta.myfilmlist.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.service.MyFilmsService;

public class MyFilmsServiceImpl implements MyFilmsService {

      private static int NB_FILMS_MIN_REALISATEUR_CELEBRE = 3;

      @Override public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException {
            try {
                  realisateur.setCelebre(realisateur.getFilmRealises().size() >= NB_FILMS_MIN_REALISATEUR_CELEBRE);
                  return realisateur;
                  
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }

      public int calculerDureeTotale(List<Film> listeFilms) {
            return listeFilms.stream().mapToInt(Film::getDuree).sum();
      }

      public double calculerNoteMoyenne(double[] notes) {
            return (double) Math.round(100*(Arrays.stream(notes).average().getAsDouble()))/100;
      }
}
