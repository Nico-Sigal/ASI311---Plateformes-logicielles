package com.ensta.myfilmlist.service.impl;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.service.MyFilmsService;

public class MyFilmsServiceImpl implements MyFilmsService {
      public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException {
            try {
                  realisateur.setCelebre(realisateur.getFilmRealises().size() >= 3);
                  return realisateur;
                  
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }
}
