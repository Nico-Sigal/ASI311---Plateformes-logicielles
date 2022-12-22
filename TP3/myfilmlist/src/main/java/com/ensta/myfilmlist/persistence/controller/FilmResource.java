package com.ensta.myfilmlist.persistence.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;

@RestController
public interface FilmResource {
      @RequestMapping("/film")
      ResponseEntity<List<FilmDTO>> getAllFilms() throws ControllerException;
}
