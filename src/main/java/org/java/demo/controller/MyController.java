package org.java.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.demo.media.Movie;
import org.java.demo.media.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {
	
	private static char[] stringMovies;

	@GetMapping("/hello")
	public String sayHelloToName(Model model,
		@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		return "index";
	}
	
	private static String getBestMovies() {
	
		List<Movie> bestMovies = new ArrayList<>();
		
		for (int i = 1; i < 10; i++) {
			Movie m1 = new Movie(i, "Movie" + i);
			bestMovies.add(m1);
		}
		
		String stringMovies = bestMovies.toString();
		
		return stringMovies;
		
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> bestSongs = new ArrayList<>();
		
		for (int i = 1; i < 10; i++) {
			Song s1 = new Song(i, "Song" + i);
			bestSongs.add(s1);
		}
		
		return bestSongs;
	}
	
	public static void main(String[] args) {
		
		getBestMovies();

		System.out.println(stringMovies);
	}
	
}
