package filRouge.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import filRouge.model.Commande;
import filRouge.model.Users;
import filRouge.repository.CommandeRepository;


@RestController
@RequestMapping("/api")
public class CommandeController {

	@Autowired
	private CommandeRepository commandeRepository;
	
	/**
	 * Get all the commandes.
	 * @return a list with all the commandes
	 * @throws Exception 
	 */
	@RequestMapping(value = "/commandes", method = RequestMethod.GET)
	public ResponseEntity<List<Commande>> getAllCommandes(){
		System.out.println(">> ok findAll");
		List<Commande> listCommande = null;
		try {
			listCommande = commandeRepository.findAll();
			for (Commande commande : listCommande) {
				System.out.println(commande);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(listCommande);
	}
	
	/**
	 * Get a specific commande based on ID
	 * @param id : the id of commande.
	 * @return the commande
	 * @throws Exception 
	 */
	@RequestMapping(value = "/commande/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCommande(@PathVariable Integer id) {		
		System.out.println(">> ok findOne");
		
		Optional<Commande> commande = null;
		
		try {
			commande = commandeRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		if(commande == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(commande);
	}
	
	/**
	 * Create a new commande.
	 * @param commande : the commande information.
	 * @throws Exception 
	 */
	@RequestMapping(value="/commande/ajout", method = RequestMethod.POST)
	public ResponseEntity<?> addCommande(@RequestBody Commande commande){
		Commande resultCommande = null;
		
		Date date = commande.getDate();
		Double prixHT = commande.getPrixHT();
		Double prixTTC = commande.getPrixTTC();
		Double tva = commande.getTva();
		Double fraisDePort = commande.getFraisDePort();
		Double total = commande.getTotal();
		Users idClient = commande.getIdClient();
		
		System.out.println(">> "+commande);
		
		if(date == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The date is not set !");
		if(prixHT == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The prixHT is not set !");
		if(prixTTC == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The prixTTC is not set !");
		if(tva == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The tva is not set !");
		if(fraisDePort == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The fraisDePort is not set !");
		if(total == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The total is not set !");
		if(idClient == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The idClient is not set !");
		
		try {
			resultCommande = commandeRepository.saveAndFlush(commande);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultCommande);

	}
	
	/**
	 * Update an existing commande.
	 * @param employee : the commande information.
	 * @param id : the id of commande.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/commande/modifier/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCommande(@RequestBody Commande commande, @PathVariable Integer id) throws Exception {
		Commande resultCommande = null;
		System.out.println(">> "+commande);
		
		Double prixHT = commande.getPrixHT();
		Double prixTTC = commande.getPrixTTC();
		if(prixHT == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The prixHT is not set !");
		if(prixTTC == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The prixTTC is not set !");
		
		try {
			resultCommande = commandeRepository.saveAndFlush(commande);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultCommande);
		
		
	}

}
