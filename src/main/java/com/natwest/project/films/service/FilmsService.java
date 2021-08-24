package com.natwest.project.films.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.project.films.persistence.domain.Films;
import com.natwest.project.films.persistence.repo.FilmsRepo;


@Service
public class FilmsService {

	public FilmsRepo repo;
	
	@Autowired
	public FilmsService(FilmsRepo repo) {
		super();
		this.repo = repo;
		
	}
	//Read all
	public List<Films> readAll() {
		return this.repo.findAll();
		
	}
	//Create
	public Films addFilms(Films films) {
		return this.repo.saveAndFlush(films);
		
	}
	
	//find by id
	public Films findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	
	//Update
	public Films update(Long id, Films films) {
		Films exists = this.repo.getById(id);
		System.out.println(exists);
		exists.setTitle(films.getTitle());
		exists.setType(films.getType());
		exists.setDuration(films.getDuration());
		Films updated = this.repo.save(exists);
		return updated;
	}
	
	//delete
	public Boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
		
	}
	//select option
	public List<Films> findByTitle(String title) {
		return this.repo.findFilmsByTitleJPQL(title);
		
	}
}