package filRouge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filRouge.model.Genre;
import filRouge.repository.GenreRepository;

@RestController
@RequestMapping("/homegenre")
public class GenreController
{

	@Autowired
	private GenreRepository genreRepo;
	
	/**
	 * Methode READ ALL GENRES
	 * @return liste de tous les genres
	 */
	@GetMapping("/get/allgenres")
	public ResponseEntity<List<Genre>> getListGenre()
	{
		List<Genre> listGenre = null;
		
		try
		{
			listGenre = genreRepo.findAll();
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listGenre);
	}
	
	/**
	 * Methode READ ONE GENRE
	 * @param idGenre
	 * @return un genre
	 */
	@GetMapping("/get/onegenre/{idGenre}")
	public ResponseEntity<?> getOneGenre(@PathVariable Integer idGenre)
	{
		Optional<Genre> genre = null;
		
		try {
			genre = genreRepo.findById(idGenre);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
		}
		if (genre == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(genre);
	}
	
	/**
	 * Methode CREATE
	 * @param information genre
	 * @return ajoute un genre
	 */
	@PostMapping("/post")
	public ResponseEntity<?> addGenre(@RequestBody Genre genre)
	{
		Genre newGenre = null;
		String typeGenre = genre.getTypeGenre();
		if ((typeGenre == null) || (typeGenre.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manque type genre");
		}
		newGenre = genreRepo.save(genre);
		return ResponseEntity.status(HttpStatus.CREATED).body(newGenre);
	}
	
	/**
	 * Methode DELETE
	 * @param idGenre
	 * @return supprime un genre
	 */
	@DeleteMapping("/delete/{idGenre}")
	public ResponseEntity<?> deleteGenre(@PathVariable Integer idGenre)
	{
		try
		{
			genreRepo.deleteById(idGenre);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Methode UPDATE
	 * @param information genre et idGenre
	 * @return modifie un genre
	 */
	@PutMapping("/put/{idGenre}")
	public ResponseEntity<?> updateGenre(@RequestBody Genre genre, @PathVariable Integer idGenre) throws Exception
	{
		Genre result = null;
		String typeGenre = genre.getTypeGenre();
		if ((typeGenre == null) || (typeGenre.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manque type genre");
		}
		try
		{
			result = genreRepo.save(genre);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
