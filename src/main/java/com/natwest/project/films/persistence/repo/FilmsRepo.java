package com.natwest.project.films.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natwest.project.films.persistence.domain.Films;

@Repository
public interface FilmsRepo extends JpaRepository<Films, Long> {

	@Query("SELECT f from Films f")
	List<Films> findAllJPQL();	
	
	@Query(value = "SELECT * from Films", nativeQuery = true)
	List<Films> findAllSQL();
	
	@Query(value = "SELECT f from Films f WHERE f.title = ?1")
	List<Films> findFilmsByTitleJPQL(String title);

	@Query(value = "SELECT * from Films WHERE name = ?1", nativeQuery = true)
	List<Films> findFilmsByTitleSQL(String title);
	
	@Query(value = "SELECT f from Films f WHERE f.type = ?1")
	List<Films> findFilmsByTypeJPQL(String type);

	@Query(value = "SELECT * from Films WHERE type = ?1", nativeQuery = true)
	List<Films> findFilmsByTypeeSQL(String type);
	
		
	@Query(value = "SELECT f from Films f WHERE f.duration > ?1")
	List<Films> findFilmsByDurationGreaterThanJPQL(int duration);

	@Query(value = "SELECT * from Films WHERE duration > ?1", nativeQuery = true)
	List<Films> findFilmsByDurationGreaterThanSQL(int duration);
	
	@Query(value = "SELECT f from Films f WHERE f.duration < ?1")
	List<Films> findFilmsByDurationLessThanJPQL(int duration);

	@Query(value = "SELECT * from Films WHERE duration < ?1", nativeQuery = true)
	List<Films> findFilmsByDurationLessThanSQL(int duration);
	
//	@Query(value = "SELECT f from Films f WHERE f.title = ?1 and f.type")
//	List<Films> findFilmsByTitleAndTypeJPQL(String title, String type);
//
//	@Query(value = "SELECT * from Films WHERE title = ?1 and type = ?2", nativeQuery = true)
//	List<Films> findFilmsByTitleAndTypeSQL(String title, String type);
	
	
	@Query(value = "SELECT f from Films f WHERE f.title != NULL")
	List<Films> findFilmsByTitleIsNotNullJPQL();

	@Query(value = "SELECT * from Films WHERE title IS NOT NULL", nativeQuery = true)
	List<Films> findFilmsByTitleIsNotNullSQL();

	@Query(value = "SELECT f from Films f WHERE f.title = NULL")
	List<Films> findFilmsByTitleIsNullJPQL();

	@Query(value = "SELECT * from Films WHERE title IS NULL", nativeQuery = true)
	List<Films> findFilmsByTitleIsNullSQL();
}






