package com.it.skill.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.skill.movies.Movie;
import com.it.skill.repo.IMovieRepo;

@Service
@Transactional
public class IMovieService {

	@Autowired
	private IMovieRepo movieRepository;

	
	public Integer addMovie(Movie movie)
	{
		//Movie movie = new Movie();
		movieRepository.save(movie);
		return movie.getMno();
		
	}
	public Iterable<Movie> addMovies(Iterable<Movie> lsMovies2)
	{
		//Movie movie = new Movie();
		Iterable<Movie> lsMovies = movieRepository.saveAll(lsMovies2);
		
		return lsMovies;
		
	}
	public List<Movie> getAllMovies()
	{
		
		List<Movie> lstMovie = new ArrayList<Movie>();
		movieRepository.findAll().forEach(e->lstMovie.add(e));
		return lstMovie;
	}
	
	public List<Movie> findMoviesByGenre(String genre)
	{
		
		List<Movie> lstMovie = new ArrayList<Movie>();
		lstMovie = movieRepository.findByGenre(genre);
		return lstMovie;
	}
	public Optional<Movie> findMoviesById(Integer id)
	{
		
		Optional<Movie> movie = Optional.ofNullable(new Movie());
		movie = movieRepository.findById(id);
		return movie;
	}
	public Boolean deleteMovie(Integer id)
	{
		//Movie movie = new Movie();
		movieRepository.deleteById(id);
		
		Optional<Movie> m = movieRepository.findById(id);
		if(m.isEmpty())
			return true;
		else
			return false;
	}
	public Movie updateMovie(Movie m)
	{
		//Movie movie = new Movie();
		if(movieRepository.existsById(m.getMno()))
				movieRepository.save(m);
		return m;
	}
}
