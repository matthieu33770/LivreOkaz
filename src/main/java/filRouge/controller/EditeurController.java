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

import filRouge.model.Editeur;
import filRouge.repository.EditeurRepository;

@RestController
@RequestMapping("/homeediteur")
public class EditeurController
{

	@Autowired
	private EditeurRepository editorRepo;
	
	/**
	 * Methode READ ALL EDITORS
	 * @return liste de tous les editeurs
	 */
	@GetMapping("/get/alleditors")
	public ResponseEntity<List<Editeur>> getListEditor()
	{
		List<Editeur> listEditeur = null;
		
		try
		{
			listEditeur = editorRepo.findAll();
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listEditeur);
	}
	
	/**
	 * Methode READ ONE EDITOR
	 * @param idEditeur
	 * @return un editeur
	 */
	@GetMapping("/get/oneeditor/{idEditeur}")
	public ResponseEntity<?> getOneEditor(@PathVariable Integer idEditeur)
	{
		Optional<Editeur> editeur = null;
		
		try {
			editeur = editorRepo.findById(idEditeur);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			
		}
		if (editeur == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(editeur);
	}
	
	/**
	 * Methode CREATE
	 * @param information editeur
	 * @return ajoute un editeur
	 */
	@PostMapping("/post")
	public ResponseEntity<?> addEditor(@RequestBody Editeur editeur)
	{
		Editeur newEditor = null;
		String nomEditeur = editeur.getNomEditeur();
		if ((nomEditeur == null) || (nomEditeur.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manque nom éditeur");
		}
		newEditor = editorRepo.save(editeur);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEditor);
	}
	
	/**
	 * Methode DELETE
	 * @param idEditeur
	 * @return supprime un editeur
	 */
	@DeleteMapping("/delete/{idEditeur}")
	public ResponseEntity<?> deleteEditor(@PathVariable Integer idEditeur)
	{
		try
		{
			editorRepo.deleteById(idEditeur);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Methode UPDATE
	 * @param information editeur et idEditeur
	 * @return modifie un editeur
	 */
	@PutMapping("/put/{idEditeur}")
	public ResponseEntity<?> updateEditor(@RequestBody Editeur editeur, @PathVariable Integer idEditeur) throws Exception
	{
		Editeur result = null;
		String nomEditeur = editeur.getNomEditeur();
		if ((nomEditeur == null) || (nomEditeur.isEmpty()))
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manque nom éditeur");
		}
		try
		{
			result = editorRepo.save(editeur);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	
	
}
