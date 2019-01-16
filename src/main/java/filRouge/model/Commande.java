package filRouge.model;

import java.io.Serializable;
import java.util.Date;

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
public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id_ouvrage")
	private int idOuvrage;
	
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
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_client")
	private Users id_client;
}
