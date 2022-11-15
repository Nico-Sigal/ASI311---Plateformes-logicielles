package com.ensta.myfilmlist.service;

import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.model.Realisateur;

public interface MyFilmsService {
      
      /**
       * @param realisateur
       * @return realisateur updaté
       * @throws ServiceException
       */
      public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException;
}
