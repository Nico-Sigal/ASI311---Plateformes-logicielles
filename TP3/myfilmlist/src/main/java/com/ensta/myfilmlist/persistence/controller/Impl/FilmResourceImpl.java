package com.ensta.myfilmlist.persistence.controller.Impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.persistence.controller.FilmResource;

public class FilmResourceImpl implements FilmResource {
      public ResponseEntity<List<FilmDTO>> getAllFilms() throws ControllerException {
            try {
                  return null;
            }
            catch (Exception e) {
                  throw new ControllerException();
            }
      }
}
