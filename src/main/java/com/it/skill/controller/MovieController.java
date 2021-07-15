package com.it.skill.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.skill.movies.Movie;
import com.it.skill.service.IMovieService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class MovieController {

	@Autowired
	private IMovieService movieService;
	
	//add single movie
	@PostMapping(path = "/movies/add/",consumes="application/json")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
		Integer iRating =  movieService.addMovie(movie);
		if(iRating!=null)
		{
			return new ResponseEntity<String>("Movie saved with rating: " +iRating, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Movie not saved", HttpStatus.NOT_ACCEPTABLE);
	}
	@PostMapping(path = "/movies/addall/", consumes = "application/json")
	public ResponseEntity<Iterable<Movie>> addMovies(@RequestBody List<Movie> lsMovie) {
		Iterable<Movie> lsMovies =  movieService.addMovies(lsMovie);
		return new ResponseEntity<Iterable<Movie>>(lsMovies, HttpStatus.CREATED);
		
		
		
	}
	@GetMapping(path = "/movies/", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> lsMovies =  movieService.getAllMovies();
		if(!lsMovies.isEmpty())
		{
			return new ResponseEntity<List<Movie>>(lsMovies, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Movie>>(HttpStatus.NOT_FOUND);
	}
	@GetMapping(path = "/movies/bygenre/{genre}", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable("genre") String genre) {
		List<Movie> lsMovies =  movieService.findMoviesByGenre(genre);
		if(!lsMovies.isEmpty())
		{
			return new ResponseEntity<List<Movie>>(lsMovies, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Movie>>(HttpStatus.EXPECTATION_FAILED);
	}
	@GetMapping(path = "/movies/{mid}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<Movie>> getMoviesId(@PathVariable("mid") Integer mid) {
		Optional<Movie> movie =  movieService.findMoviesById(mid);
		return new ResponseEntity<Optional<Movie>>(movie, HttpStatus.OK);
		/*if(!movie.)
		{
			return new ResponseEntity<Movie>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Movie>(HttpStatus.EXPECTATION_FAILED);*/
	}
	@DeleteMapping(path = "/movies/delete/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<String> deleteMovieById(@PathVariable("id") int id) {
		Boolean bDelete = movieService.deleteMovie(id);
		if(bDelete)
		{
			return new ResponseEntity<String>("Movie is deleted with Id: " + id, HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	@PutMapping(path = "/movies/update/{movieId}", consumes = "application/json")
	public ResponseEntity<String> updateProject(@RequestBody Movie movie) {
		
		Movie m =  movieService.updateMovie(movie);
		if(!(m==null))
		{
			return new ResponseEntity<String>("Movie saved with Id: " +m.getMno(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Movie not saved", HttpStatus.NOT_ACCEPTABLE);
		
	}
	//add list of projects
/*	@PostMapping(path = "/project-resources/addall/projects", consumes = "application/json")
	public List<Integer> addProjects(@RequestBody List<Project> lsProject) {
		List<Integer> lsId =  projectService.addProjects(lsProject);
		
		
		return lsId;	
	}

	@GetMapping(path = "/project-resources/projects/{projectId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<String> getProjectInfo(@PathVariable("projectId") int projectId) {
		Project p = projectService.getProject(projectId);
		if(p!=null)
		{
			return new ResponseEntity<String>("Project found with Id: " +p.getSerialNo(), HttpStatus.FOUND);
		}
		return new ResponseEntity<String>("Project not found: ", HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/project-resources/getall/projects", produces = "application/json")
	public List<Project> getAllProjectInfo() {
		return projectService.getAllProject();
	}

	@DeleteMapping(path = "/project-resources/projects/delete/{projectId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<String> deleteProject(@PathVariable("projectId") int projectId) {
		Boolean bDelete = projectService.deleteProject(projectId);
		if(bDelete)
			return new ResponseEntity<String>("Project deleted with Id: " + projectId,HttpStatus.GONE);
		else
			return new ResponseEntity<String>("Failed to delete project with Id: " + projectId,HttpStatus.EXPECTATION_FAILED);
		
	}
	@PutMapping(path = "/project-resources/projects/update/{projectId}", consumes = "application/json")
	public ResponseEntity<String> updateProject(@RequestBody Project project) {
		
		Project p =  projectService.updateProject(project);
		if(p.getSerialNo()>1)
		{
			return new ResponseEntity<String>("Project saved with Id: " +p.getSerialNo(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Project not saved", HttpStatus.NOT_ACCEPTABLE);
		
	}
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException exception) {

		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProjectNotSavedException.class)
	public ResponseEntity<String> handleProjectNotSavedException(ProjectNotSavedException exception) {

		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(path="/project-resources/projects",method=RequestMethod.GET,produces="application/json" )
	public Project getProjectInfo()
	{
		return new Project(1,"Arundhati",5,"ScrumTeam");
	}*/
}
