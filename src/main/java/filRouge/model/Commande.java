package filRouge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id_commande")
	private int idCommande;
	
	@Size(max = 10)
	@Column(name = "date")
	private Date date;
	
	@Size(max = 10)
	@Column(name = "prixHT")
	private Double prixHT;
	
	@Size(max = 10)
	@Column(name = "prixTTC")
	private Double prixTTC;
	
	@Size(max = 10)
	@Column(name = "tva")
	private Double tva;
	
	@Size(max = 10)
	@Column(name = "fraisDePort")
	private Double fraisDePort;
	
	@Size(max = 10)
	@Column(name = "total")
	private Double total;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_client")
	private Users idClient;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="nom_client")
	private Users nomClient;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="prenom_client")
	private Users prenomClient;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="numeroFacturation")
	private Users numeroFacturation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="rueFacturation")
	private Users rueFacturation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="complementFacturation")
	private Users complementFacturation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cpFacturation")
	private Users cpFacturation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="villeFacturation")
	private Users villeFacturation;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="numeroLivraison")
	private Users numeroLivraison;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="rueLivraison")
	private Users rueLivraison;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="complementLivraison")
	private Users complementLivraison;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="cpLivraison")
	private Users cpLivraison;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="villeLivraison")
	private Users villeLivraison;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="ouvrage")
	private List<Ouvrage> ouvrages;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="quantite")
	private List<Ouvrage> quantite;

	public Commande() {
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(Double prixHT) {
		this.prixHT = prixHT;
	}

	public Double getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(Double prixTTC) {
		this.prixTTC = prixTTC;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public Double getFraisDePort() {
		return fraisDePort;
	}

	public void setFraisDePort(Double fraisDePort) {
		this.fraisDePort = fraisDePort;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Users getIdClient() {
		return idClient;
	}

	public void setIdClient(Users idClient) {
		this.idClient = idClient;
	}

	public Users getNomClient() {
		return nomClient;
	}

	public void setNomClient(Users nomClient) {
		this.nomClient = nomClient;
	}

	public Users getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(Users prenomClient) {
		this.prenomClient = prenomClient;
	}

	public Users getNumeroFacturation() {
		return numeroFacturation;
	}

	public void setNumeroFacturation(Users numeroFacturation) {
		this.numeroFacturation = numeroFacturation;
	}

	public Users getRueFacturation() {
		return rueFacturation;
	}

	public void setRueFacturation(Users rueFacturation) {
		this.rueFacturation = rueFacturation;
	}

	public Users getComplementFacturation() {
		return complementFacturation;
	}

	public void setComplementFacturation(Users complementFacturation) {
		this.complementFacturation = complementFacturation;
	}

	public Users getCpFacturation() {
		return cpFacturation;
	}

	public void setCpFacturation(Users cpFacturation) {
		this.cpFacturation = cpFacturation;
	}

	public Users getVilleFacturation() {
		return villeFacturation;
	}

	public void setVilleFacturation(Users villeFacturation) {
		this.villeFacturation = villeFacturation;
	}

	public Users getNumeroLivraison() {
		return numeroLivraison;
	}

	public void setNumeroLivraison(Users numeroLivraison) {
		this.numeroLivraison = numeroLivraison;
	}

	public Users getRueLivraison() {
		return rueLivraison;
	}

	public void setRueLivraison(Users rueLivraison) {
		this.rueLivraison = rueLivraison;
	}

	public Users getComplementLivraison() {
		return complementLivraison;
	}

	public void setComplementLivraison(Users complementLivraison) {
		this.complementLivraison = complementLivraison;
	}

	public Users getCpLivraison() {
		return cpLivraison;
	}

	public void setCpLivraison(Users cpLivraison) {
		this.cpLivraison = cpLivraison;
	}

	public Users getVilleLivraison() {
		return villeLivraison;
	}

	public void setVilleLivraison(Users villeLivraison) {
		this.villeLivraison = villeLivraison;
	}

	public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}

	public List<Ouvrage> getQuantite() {
		return quantite;
	}

	public void setQuantite(List<Ouvrage> quantite) {
		this.quantite = quantite;
	}

	public Commande(int idCommande, @Size(max = 10) Date date, @Size(max = 10) Double prixHT,
			@Size(max = 10) Double prixTTC, @Size(max = 10) Double tva, @Size(max = 10) Double fraisDePort,
			@Size(max = 10) Double total, Users idClient, Users nomClient, Users prenomClient, Users numeroFacturation,
			Users rueFacturation, Users complementFacturation, Users cpFacturation, Users villeFacturation,
			Users numeroLivraison, Users rueLivraison, Users complementLivraison, Users cpLivraison,
			Users villeLivraison, List<Ouvrage> ouvrages, List<Ouvrage> quantite) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.prixHT = prixHT;
		this.prixTTC = prixTTC;
		this.tva = tva;
		this.fraisDePort = fraisDePort;
		this.total = total;
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
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
		this.ouvrages = ouvrages;
		this.quantite = quantite;
	}
	
	

}
