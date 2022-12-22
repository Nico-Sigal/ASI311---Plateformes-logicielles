package com.ensta.myfilmlist.dao;

import java.util.List;

import com.ensta.myfilmlist.model.Film;

public interface FilmDAO {
      public List<Film> findAll();
}
