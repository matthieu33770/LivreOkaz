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
import filRouge.model.Users;
import filRouge.repository.UsersRepository;

@RestController
@RequestMapping("/homeuser")
@CrossOrigin("http://localhost:4200")
public class UserController {

		@Autowired
		private UsersRepository usersRepository;
		
		/**
		 * Get all the users.
		 * @return a list with all the users
		 * @throws Exception 
		 */
		@GetMapping("/users")
		public ResponseEntity<List<Users>> getAll(){
			
			List<Users> listUser = null;
			
			try {
				listUser = usersRepository.findAll();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.status(HttpStatus.OK).body(listUser);
		}
		
		/**
		 * Get a specific user based on ID
		 * @param id : the id of user.
		 * @return the user
		 * @throws Exception 
		 */
		@GetMapping("/user/{id}")
		public ResponseEntity<?> getUserById(@PathVariable Integer id){

			Optional<Users> user = null;
					
			try {
				user = usersRepository.findById(id);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
			
			if(user == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		
		/**
		 * Get a specific user based on name
		 * @param name : the name of user.
		 * @return the user
		 * @throws Exception 
		 */
		@GetMapping("/username/{nom}")
		public ResponseEntity<?> getUserByName(@PathVariable String nom){

			List<Users> user = null;
					
			try {
				user = usersRepository.findBynom(nom);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
			
			if(user == null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		
		/**
		 * Create a new user.
		 * @param user : the user information.
		 * @throws Exception 
		 */
		@PostMapping("/user/ajout")
		public ResponseEntity<?> addUser(@RequestBody Users user){
			Users resultUser = null;
			String nom = user.getNom();
			
			if((nom == null) || (nom.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom n'est pas renseign�");
			
			String prenom = user.getPrenom();
			
			if((prenom == null) || (prenom.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le prenom n'est pas renseign�");
			
			String email = user.getEmail();
			
			if((email == null) || (email.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'email n'est pas renseign�");
			
			String mdp = user.getMdp();
			
			if((mdp == null) || (mdp.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le mdp n'est pas renseign�");
			
			
			try {
				resultUser = usersRepository.saveAndFlush(user);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(resultUser);
		}
		
		/**
		 * Update an existing user.
		 * @param user : the user information.
		 * @param id : the id of user.
		 * @throws Exception 
		 */
		@PutMapping("/user/modifier/{id}")
		public ResponseEntity<?> updateActor(@RequestBody Users user,@PathVariable Integer id) throws Exception {
			
			Users result = null;

			String nom = user.getNom();
			if((nom == null) || (nom.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom n'est pas renseign�");
			
			String prenom = user.getPrenom();
			if((prenom == null) || (prenom.isEmpty()))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le pr�nom n'est pas renseign�");
			
			try {
				result = usersRepository.save(user);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		
		/**
		 * Delete an existing user.
		 * @param id : the id of user.
		 * @throws Exception
		 */
		@DeleteMapping("/user/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable Integer id){
			try {
			usersRepository.deleteById(id);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
}
