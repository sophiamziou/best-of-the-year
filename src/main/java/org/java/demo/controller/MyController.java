package org.java.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.demo.media.Movie;
import org.java.demo.media.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MyController {

	@GetMapping("/")
	public String sayHelloToName(Model model) {
		model.addAttribute("name", "Sophia");
		return "index";
	}
	
	private List<Movie> getBestMovies() {
	
		List<Movie> bestMovies = new ArrayList<>();
		
	    Movie m1 = new Movie(1, "Movie 1");
	    Movie m2 = new Movie(2, "Movie 2");
	    Movie m3 = new Movie(3, "Movie 3");
	    Movie m4 = new Movie(4, "Movie 4");
	    Movie m5 = new Movie(5, "Movie 5");
	    Movie m6 = new Movie(6, "Movie 6");

	    bestMovies.add(m1);
	    bestMovies.add(m2);
	    bestMovies.add(m3);
	    bestMovies.add(m4);
	    bestMovies.add(m5);
	    bestMovies.add(m6);
	    
		return bestMovies;
		
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> bestSongs = new ArrayList<>();
		
	    Song s1 = new Song(1, "Song 1");
	    Song s2 = new Song(2, "Song 2");
	    Song s3 = new Song(3, "Song 3");
	    Song s4 = new Song(4, "Song 4");
	    Song s5 = new Song(5, "Song 5");
	    Song s6 = new Song(6, "Song 6");

	    bestSongs.add(s1);
	    bestSongs.add(s2);
	    bestSongs.add(s3);
	    bestSongs.add(s4);
	    bestSongs.add(s5);
	    bestSongs.add(s6);
		
		return bestSongs;
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
	    List<Movie> bestMovies = getBestMovies();
	    model.addAttribute("medias", bestMovies);
	    return "movie";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
	    List<Song> bestSongs = getBestSongs();
	    model.addAttribute("medias", bestSongs);
	    return "song";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(Model model, @PathVariable("id") int id) {
		
		Movie selectedMovie = null;
	    for (Movie m : getBestMovies()) {
	        if (m.getId() == id) {
	            selectedMovie = m;
	            break;
	        }
	    }

	    if (selectedMovie != null) {
	        model.addAttribute("media", selectedMovie);
	    } else {
	        model.addAttribute("media", "no movie found");
	    }
		
		return "detail";
		
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(Model model, @PathVariable("id") int id) {
		
		Song selectedSong = null;
		
	    for (Song s : getBestSongs()) {
	        if (s.getId() == id) {
	            selectedSong = s;
	            break;
	        }
	    }

	    if (selectedSong != null) {
	        model.addAttribute("media", selectedSong);
	    } else {
	        model.addAttribute("media", "no movie found");
	    }
		
		return "detail";
	}
}
