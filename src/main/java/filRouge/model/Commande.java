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

}
