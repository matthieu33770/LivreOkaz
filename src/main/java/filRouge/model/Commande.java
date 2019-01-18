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
	@Column(name = "prixht")
	private Double prixHT;
	
	@Size(max = 10)
	@Column(name = "prixttc")
	private Double prixTTC;
	
	@Size(max = 10)
	@Column(name = "tva")
	private Double tva;
	
	@Size(max = 10)
	@Column(name = "frais_de_port")
	private Double fraisDePort;
	
	@Size(max = 10)
	@Column(name = "total")
	private Double total;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_client")
	private Users idClient;
	

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

	public Commande(int idCommande, @Size(max = 10) Date date, @Size(max = 10) Double fraisDePort,
			@Size(max = 10) Double prixHT, @Size(max = 10) Double prixTTC, @Size(max = 10) Double total, 
			@Size(max = 10) Double tva, Users idClient) {
		super();
		this.idCommande = idCommande;
		this.date = date;
		this.fraisDePort = fraisDePort;
		this.prixHT = prixHT;
		this.prixTTC = prixTTC;
		this.total = total;
		this.tva = tva;	
		this.idClient = idClient;

	}	
	

}
