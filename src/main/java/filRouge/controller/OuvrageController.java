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

import filRouge.model.Auteur;
import filRouge.model.Editeur;
import filRouge.model.Genre;
import filRouge.model.Ouvrage;
import filRouge.repository.OuvrageRepository;

@RestController
@RequestMapping("/homebook")
public class OuvrageController
{

	@Autowired
	private OuvrageRepository bookRepo;
	
	/**
	 * Methode READ ALL BOOKS
	 * @return liste de tous les ouvrages
	 */
	@GetMapping("/ouvrage/allbooks")
	public ResponseEntity<List<Ouvrage>> getListBook()
	{
		List<Ouvrage> listBook = null;
		
		try
		{
			listBook = bookRepo.findAll();
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listBook);
	}
	
	/**
	 * Methode READ ONE BOOK
	 * @param idOuvrage
	 * @return un ouvrage
	 */
	@GetMapping("/ouvrage/onebook/{idOuvrage}")
	public ResponseEntity<?> getOneBook(@PathVariable Integer idOuvrage)
	{
		Optional<Ouvrage> book = null;
		
		try {
			book = bookRepo.findById(idOuvrage);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
		}
		if (book == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	/**
	 * Methode CREATE
	 * @param information ouvrage
	 * @return ajoute un ouvrage
	 */
	@PostMapping("/ouvrage/createbook")
	public ResponseEntity<?> addBook(@RequestBody Ouvrage book)
	{
		Ouvrage newBook = null;
		
//		String titre = book.getTitre();
//		if ((titre == null) || titre.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message titre");
//		}
//		
//		String isbn = book.getIsbn();
//		if ((isbn == null) || isbn.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message isbn");
//		}
		
//		String imagecouv = book.getImagecouv();
//		if ((imagecouv == null) || (imagecouv.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message imagecouv");
//		}
		
//		String sujet = book.getSujet();
//		if ((sujet == null) || (sujet.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message sujet");
//		}
//		
//		String description = book.getDescription();
//		if ((description == null) || (description.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message description");
//		}
//		
//		String langue = book.getLangue();
//		if ((langue == null) || (langue.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message langue");
//		}
//		
//		int anneeParution = book.getAnneeParution();
//		if ((anneeParution == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message anneeParution");
//		}
		
		
//		int quantiteStock = book.getQuantiteStock();
//		if ((quantiteStock == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message quantiteStock");
//		}
		
//		double prixNeuf = book.getPrixNeuf();
//		if ((prixNeuf == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message prixNeuf");
//		}
		
		
//		double prixVente = book.getPrixVente();
//		if ((prixVente == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message prixVente");
//		}
		
		
//		List<Auteur> auteurs = book.getAuteurs();
//		if ((auteurs == null) || (auteurs.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message auteur");
//		}
		
//		Editeur editeur = book.getEditeur();
//		if ((editeur == null))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message editeur");
//		}
		
//		List<Genre> genres = book.getGenres();
//		if ((genres == null) || (genres.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message genre");
//		}
		
		newBook = bookRepo.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
	}
	
	/**
	 * Methode DELETE
	 * @param idOuvrage
	 * @return supprime un ouvrage
	 */
	@DeleteMapping("/ouvrage/delete/{idOuvrage}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer idOuvrage)
	{
		try
		{
			bookRepo.deleteById(idOuvrage);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Methode UPDATE
	 * @param information ouvrage et idOuvrage
	 * @return modifie un ouvrage
	 */
	@PutMapping("/ouvrage/modifybook/{idOuvrage}")
	public ResponseEntity<?> updateBook(@RequestBody Ouvrage book, @PathVariable Integer idOuvrage) throws Exception
	{
		Ouvrage result = null;
		
//		String titre = book.getTitre();
//		if ((titre == null) || titre.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message titre");
//		}
//		
//		String isbn = book.getIsbn();
//		if ((isbn == null) || isbn.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message isbn");
//		}
//		
//		String imagecouv = book.getImagecouv();
//		if ((imagecouv == null) || (imagecouv.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message imagecouv");
//		}
//		
//		String sujet = book.getSujet();
//		if ((sujet == null) || (sujet.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message sujet");
//		}
//		
//		String description = book.getDescription();
//		if ((description == null) || (description.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message description");
//		}
//		
//		String langue = book.getLangue();
//		if ((langue == null) || (langue.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message langue");
//		}
//		
//		int anneeParution = book.getAnneeParution();
//		if ((anneeParution == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message anneeParution");
//		}
//		
//		
//		int quantiteStock = book.getQuantiteStock();
//		if ((quantiteStock == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message quantiteStock");
//		}
//		
//		double prixNeuf = book.getPrixNeuf();
//		if ((prixNeuf == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message prixNeuf");
//		}
//		
//		
//		double prixVente = book.getPrixVente();
//		if ((prixVente == 0))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message prixVente");
//		}
//		
//		
//		List<Auteur> auteurs = book.getAuteurs();
//		if ((auteurs == null) || (auteurs.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message auteur");
//		}
//		
//		Editeur editeur = book.getEditeur();
//		if ((editeur == null))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message editeur");
//		}
//		
//		List<Genre> genres = book.getGenres();
//		if ((genres == null) || (genres.isEmpty()))
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message genre");
//		}
		
		try
		{
			result = bookRepo.save(book);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	

	
	
}
