package filRouge.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_users")
	private Integer id;

	@Size(max = 100)
	@Column(name = "nom")
	private String nom;

	@Size(max = 100)
	@Column(name = "prenom")
	private String prenom;

	@Size(max = 255)
	@Column(name = "email")
	private String email;
	
	@Size(max = 3)
	@Column(name = "numeroFacturation")
	private Integer numeroFacturation;
	
	@Size(max = 255)
	@Column(name = "rueFacturation")
	private String rueFacturation;
	
	@Size(max = 255)
	@Column(name = "complementFacturation")
	private String complementFacturation;
	
	@Size(max = 5)
	@Column(name = "cpFacturation")
	private Integer cpFacturation;
	
	@Size(max = 255)
	@Column(name = "villeFacturation")
	private String villeFacturation;
	
	@Size(max = 3)
	@Column(name = "numeroLivraison")
	private Integer numeroLivraison;
	
	@Size(max = 255)
	@Column(name = "rueLivraison")
	private String rueLivraison;
	
	@Size(max = 255)
	@Column(name = "complementLivraison")
	private String complementLivraison;
	
	@Size(max = 5)
	@Column(name = "cpLivraison")
	private Integer cpLivraison;
	
	@Size(max = 255)
	@Column(name = "villeLivraison")
	private String villeLivraison;
	
	@Size(max = 12)
	@Column(name = "telephone")
	private Integer telephone;
	
	@Size(max = 50)
	@Column(name = "mdp")
	private String mdp;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_role")
	private Role habilitation;

	
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroFacturation() {
		return numeroFacturation;
	}

	public void setNumeroFacturation(Integer numeroFacturation) {
		this.numeroFacturation = numeroFacturation;
	}

	public String getRueFacturation() {
		return rueFacturation;
	}

	public void setRueFacturation(String rueFacturation) {
		this.rueFacturation = rueFacturation;
	}

	public String getComplementFacturation() {
		return complementFacturation;
	}

	public void setComplementFacturation(String complementFacturation) {
		this.complementFacturation = complementFacturation;
	}

	public Integer getCpFacturation() {
		return cpFacturation;
	}

	public void setCpFacturation(Integer cpFacturation) {
		this.cpFacturation = cpFacturation;
	}

	public String getVilleFacturation() {
		return villeFacturation;
	}

	public void setVilleFacturation(String villeFacturation) {
		this.villeFacturation = villeFacturation;
	}

	public Integer getNumeroLivraison() {
		return numeroLivraison;
	}

	public void setNumeroLivraison(Integer numeroLivraison) {
		this.numeroLivraison = numeroLivraison;
	}

	public String getRueLivraison() {
		return rueLivraison;
	}

	public void setRueLivraison(String rueLivraison) {
		this.rueLivraison = rueLivraison;
	}

	public String getComplementLivraison() {
		return complementLivraison;
	}

	public void setComplementLivraison(String complementLivraison) {
		this.complementLivraison = complementLivraison;
	}

	public Integer getCpLivraison() {
		return cpLivraison;
	}

	public void setCpLivraison(Integer cpLivraison) {
		this.cpLivraison = cpLivraison;
	}

	public String getVilleLivraison() {
		return villeLivraison;
	}

	public void setVilleLivraison(String villeLivraison) {
		this.villeLivraison = villeLivraison;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Role getHabilitation() {
		return habilitation;
	}

	public void setHabilitation(Role habilitation) {
		this.habilitation = habilitation;
	}

	public Users() {
	}

	public Users(Integer id, @Size(max = 100) String nom, @Size(max = 100) String prenom, @Size(max = 255) String email,
			@Size(max = 3) Integer numeroFacturation, @Size(max = 255) String rueFacturation,
			@Size(max = 255) String complementFacturation, @Size(max = 5) Integer cpFacturation,
			@Size(max = 255) String villeFacturation, @Size(max = 3) Integer numeroLivraison,
			@Size(max = 255) String rueLivraison, @Size(max = 255) String complementLivraison,
			@Size(max = 5) Integer cpLivraison, @Size(max = 255) String villeLivraison,
			@Size(max = 12) Integer telephone, @Size(max = 50) String mdp, Role habilitation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numeroFacturation = numeroFacturation;
		this.rueFacturation = rueFacturation;
		this.complementFacturation = complementFacturation;
		this.cpFacturation = cpFacturation;
		this.villeFacturation = villeFacturation;
		this.numeroLivraison = numeroLivraison;
		this.rueLivraison = rueLivraison;
		this.complementLivraison = complementLivraison;
		this.cpLivraison = cpLivraison;
		this.villeLivraison = villeLivraison;
		this.telephone = telephone;
		this.mdp = mdp;
		this.habilitation = habilitation;
	}

	public Users(Integer id, @Size(max = 100) String nom, @Size(max = 100) String prenom, @Size(max = 255) String email,
			@Size(max = 50) String mdp, Role habilitation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.habilitation = habilitation;
	}

	
	
}
