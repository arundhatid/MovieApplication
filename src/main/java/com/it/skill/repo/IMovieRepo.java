package com.it.skill.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.it.skill.movies.Movie;

@Repository 
@Transactional
public interface IMovieRepo extends CrudRepository<Movie, Integer>{

	//@Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)

	//@Query(value = "SELECT * FROM movie m where m.genre=?1",nativeQuery=true)
	//public List<Movie> findByGenre(String genre);	
	public List<Movie> findByGenre(@Param("genre") String genre);	
}
