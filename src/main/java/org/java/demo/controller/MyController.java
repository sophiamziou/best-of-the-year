package org.java.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.java.demo.media.Movie;
import org.java.demo.media.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {

	@GetMapping("/hello")
	public String sayHelloToName(Model model) {
		model.addAttribute("name", "Sophia");
		return "index";
	}
	
	private List<Movie> getBestMovies() {
	
		List<Movie> bestMovies = new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			Movie m = new Movie(i, "Movie" + i);
			bestMovies.add(m);
		}
		
		return bestMovies;
		
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> bestSongs = new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			Song s = new Song(i, "Song" + i);
			bestSongs.add(s);
		}
		
		return bestSongs;
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		String mts = "";
		Iterator<Movie> it = getBestMovies().iterator();
		while(it.hasNext()) {
			mts += it.next().getTitle();
			
			if (it.hasNext())
				mts += ", ";
		}
		model.addAttribute("title", mts);
		return "media";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		String mts = "";
		Iterator<Song> it = getBestSongs().iterator();
		while(it.hasNext()) {
			mts += it.next().getTitle();
			
			if (it.hasNext())
				mts += ", ";
		}
		model.addAttribute("title", mts);
		return "media";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(Model model, @PathVariable("id") int id) {

		String resT = null;
		for (Movie m : getBestMovies()) 
			if (m.getId() == id) 
				resT = m.getTitle();
		
		if (resT != null)
			model.addAttribute("title", resT);
		else 
			model.addAttribute("title", "no movie found");
		
		return "media";
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(Model model, @PathVariable("id") int id) {
		
		Song resS = null;
		for (Song s : getBestSongs())
			if (s.getId() == id)
				resS = s;
		
		if (resS != null)
			model.addAttribute("title", resS.getTitle());
		
		return "media";
	}
}
