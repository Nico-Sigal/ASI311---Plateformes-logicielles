package com.ensta.myfilmlist.service.impl;

import com.ensta.myfilmlist.exception.ServiceException;
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
}
