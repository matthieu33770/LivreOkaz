package filRouge.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import filRouge.model.Role;
import filRouge.repository.RoleRepository;

@RestController
@RequestMapping("/homerole")
@CrossOrigin("http://localhost:4200")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * Get all the role.
	 * @return a list with all the roles
	 * @throws Exception 
	 */
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAll(){
		
		List<Role> listRole = null;
		
		try {
			listRole = roleRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(listRole);
	}
	
	/**
	 * Get a specific role based on ID
	 * @param id : the id of role.
	 * @return the role
	 * @throws Exception 
	 */
	@GetMapping("/role/{id}")
	public ResponseEntity<?> getRoleById(@PathVariable Integer id){

		Optional<Role> role = null;
				
		try {
			role = roleRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		if(role == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		
		return ResponseEntity.status(HttpStatus.OK).body(role);
	}

	/**
	 * Create a new role.
	 * @param role : the user information.
	 * @throws Exception 
	 */
	@PostMapping("/role/ajout")
	public ResponseEntity<?> addRole(@RequestBody Role role){
		Role resultRole = null;
		String fonction = role.getFonction();
		
		if((fonction == null) || (fonction.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fonction n'est pas renseign�e");

		try {
			resultRole = roleRepository.saveAndFlush(role);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(resultRole);
	}
	
	/**
	 * Update an existing role.
	 * @param role : the role information.
	 * @param id : the id of role.
	 * @throws Exception 
	 */
	@PutMapping("/role/modifier/{id}")
	public ResponseEntity<?> updateRole(@RequestBody Role role,@PathVariable Integer id) throws Exception {
		
		Role result = null;
		getRoleById(id);

		String fonction = role.getFonction();
		if((fonction == null) || (fonction.isEmpty()))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fonction n'est pas renseign�");
		
		try {
			result = roleRepository.save(role);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	/**
	 * Delete an existing role.
	 * @param id : the id of role.
	 * @throws Exception
	 */
	@DeleteMapping("/role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable Integer id){
		try {
		roleRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}