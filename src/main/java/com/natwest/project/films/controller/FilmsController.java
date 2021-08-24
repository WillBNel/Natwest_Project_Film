package com.natwest.project.films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.project.films.persistence.domain.Films;
import com.natwest.project.films.service.FilmsService;

@RestController
public class FilmsController {

	private FilmsService service;
	
	
	@Autowired
	public FilmsController(FilmsService service) {
		super();
		this.service = service;
	}

	@GetMapping("/readAll")
	public ResponseEntity<List<Films>> getAll() {
		return new ResponseEntity<List<Films>>(this.service.readAll(), HttpStatus.OK);

	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Films> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Films>(this.service.findById(id), HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<Films> create(@RequestBody Films films) {
		return new ResponseEntity<Films>(this.service.addFilms(films), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Films> update(@PathVariable("id") Long id, @RequestBody Films films) {
		return new ResponseEntity<Films>(this.service.update(id, films), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

	@GetMapping("/findByTitle/{title}")
	public ResponseEntity<List<Films>> findByType(@PathVariable String title) {
		return new ResponseEntity<List<Films>>(this.service.findByTitle(title), HttpStatus.OK);

	}

}