package com.ensta.myfilmlist.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.form.FilmForm;
import com.ensta.myfilmlist.mapper.FilmMapper;
import com.ensta.myfilmlist.mapper.RealisateurMapper;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.service.MyFilmsService;

@Service
public class MyFilmsServiceImpl implements MyFilmsService {

      private static int NB_FILMS_MIN_REALISATEUR_CELEBRE = 3;

      @Autowired
      FilmDAO filmDAO;
      @Autowired
      RealisateurDAO realisateurDAO;

      @Override public Realisateur updateRealisateurCelebre(Realisateur realisateur) throws ServiceException {
            try {
                  realisateur.setCelebre(realisateur.getFilmRealises().size() >= NB_FILMS_MIN_REALISATEUR_CELEBRE);
                  return realisateur;
                  
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }

      @Override public int calculerDureeTotale(List<Film> listeFilms) throws ServiceException {
            try {
                  return listeFilms.stream().mapToInt(Film::getDuree).sum();
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }

      @Override public double calculerNoteMoyenne(double[] notes) throws ServiceException {
            try {
                  return (double) Math.round(100*(Arrays.stream(notes).average().getAsDouble()))/100;
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }

      @Override public List<Realisateur> updateRealisateurCelebres(List<Realisateur> listeRealisateurs) throws ServiceException {
            try {
                  return listeRealisateurs.stream().map(realisateur->{
                        try {
                              return updateRealisateurCelebre(realisateur);
                        } catch (ServiceException e) {
                              e.printStackTrace();
                        }
                        return realisateur;
                  }).filter(Realisateur::isCelebre).collect(Collectors.toList());
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }
      
      @Override public List<FilmDTO> findAllFilms() throws ServiceException {
            try {
                  List<Film> listeFilms = filmDAO.findAll();
                  return FilmMapper.convertFilmToFilmDTOs(listeFilms);
            } catch (Exception e) {
                  throw new ServiceException();
            }
      }

      @Override
      public FilmDTO createFilm(FilmForm filmForm) throws ServiceException {
            Optional<Realisateur> optionalRealisateur = realisateurDAO.findById(filmForm.getRealisateurId());
            if(optionalRealisateur.isPresent()) {
                  Film film = FilmMapper.convertFilmFormToFilm(filmForm);
                  film.setRealisateur(optionalRealisateur.get());
                  return FilmMapper.convertFilmToFilmDTO(
                        filmDAO.save(film));
            }
            throw new ServiceException("Non Existent Real");
      }

      @Override
      public FilmDTO findFilmById(long id) throws ServiceException {
            Optional<Film> optFilmDTO = filmDAO.findById(id);
            if(optFilmDTO.isPresent()) {
                  return FilmMapper.convertFilmToFilmDTO(optFilmDTO.get());
            }
            return null;
      }

      @Override
      public void deleteFilm(long id) throws ServiceException {
            Optional<Film> optFilm = filmDAO.findById(id);
            if(optFilm.isPresent()) {
                  filmDAO.delete(optFilm.get());
            } else {
                  throw new ServiceException("Non Existent Film");
            }
      }

      @Override
      public List<RealisateurDTO> findAllRealisateurs() throws ServiceException {
            return RealisateurMapper.convertRealisateursToRealisateurDTOs(realisateurDAO.findAll());
      }        

      @Override
      public RealisateurDTO findRealisateurByNomAndPrenom(String nom, String prenom) throws ServiceException {
            Realisateur realisateur = realisateurDAO.findByNomAndPrenom(nom, prenom);
            if(realisateur==null) {
            return null;
            }
            return RealisateurMapper.convertRealisateurToRealisateurDTO(realisateur);
      }
}