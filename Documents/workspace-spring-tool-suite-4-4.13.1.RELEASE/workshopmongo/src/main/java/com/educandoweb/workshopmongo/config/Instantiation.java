package com.educandoweb.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.dto.AuthorDTO;
import com.educandoweb.workshopmongo.dto.ComentDTO;
import com.educandoweb.workshopmongo.repository.PostRepository;
import com.educandoweb.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acodei Feliz", new AuthorDTO(maria));

		ComentDTO c1 = new ComentDTO("Boa viagem", sdf.parse("27/03/2022"), new AuthorDTO(alex));
		ComentDTO c2 = new ComentDTO("Aproveite", sdf.parse("22/03/2022"), new AuthorDTO(bob));
		ComentDTO c3 = new ComentDTO("Tenha um ótimo dia", sdf.parse("23/03/2022"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post1.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
	}

}
