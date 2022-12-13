package com.ensta.myfilmlist.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.FilmMapper;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.service.MyFilmsService;

@Service
public class MyFilmsServiceImpl implements MyFilmsService {

      private static int NB_FILMS_MIN_REALISATEUR_CELEBRE = 3;

      @Autowired
      private FilmDAO filmDAO;

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

      public List<FilmDTO> findAllFilms(){
            List<Film> listeFilms = filmDAO.findAll();
            return FilmMapper.convertFilmToFilmDTOs(listeFilms);
      }
}
