package com.springmvc.mock.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.mock.models.Movie;
import com.springmvc.mock.models.Showtime;
import com.springmvc.mock.models.User;
import com.springmvc.mock.repositories.MovieRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminMovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getAllMovie(){
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElse(null);
	}
	
	@Value("${file.upload.directory}")
    private String uploadDir;
	
	public void saveMovie(Movie movie, MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			Path path = Paths.get(uploadDir + filename);
			Files.write(path, file.getBytes());
			movie.setImage(filename);
		}
		movieRepository.save(movie);
	}
	
	public void delMovie(Long id) {
		movieRepository.deleteById(id);
	}
}
