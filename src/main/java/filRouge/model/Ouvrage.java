package filRouge.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Ouvrage implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@TableGenerator(name = "ouvrage_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ouvrage_gen")
	private int idOuvrage;
	private String titre;
	private int isbn;
	private String imagecouv;
	private String description;
	private String langue;
	private int anneeParution;
	private int quantiteStock;
	private double prixNeuf;
	private double prixVente;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_auteur", joinColumns = @joi  (name = "idouvrage"), inverseJoinColumns = @JoinColumn(name = "idauteur"))
	private List<Auteur> auteurs;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_editeur", joinColumns = @JoinColumn(name = "idouvrage"), inverseJoinColumns = @JoinColumn(name = "idediteur"))
	private List<Editeur> editeurs;
	
	private List<Genre> genres;
	
	public Ouvrage()
	{
	
	}

	public int getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getImagecouv() {
		return imagecouv;
	}

	public void setImagecouv(String imagecouv) {
		this.imagecouv = imagecouv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public int getAnneeParution() {
		return anneeParution;
	}

	public void setAnneeParution(int anneeParution) {
		this.anneeParution = anneeParution;
	}

	public int getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public double getPrixNeuf() {
		return prixNeuf;
	}

	public void setPrixNeuf(double prixNeuf) {
		this.prixNeuf = prixNeuf;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeParution;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idOuvrage;
		result = prime * result + ((imagecouv == null) ? 0 : imagecouv.hashCode());
		result = prime * result + isbn;
		result = prime * result + ((langue == null) ? 0 : langue.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixNeuf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prixVente);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantiteStock;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		if (anneeParution != other.anneeParution)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idOuvrage != other.idOuvrage)
			return false;
		if (imagecouv == null) {
			if (other.imagecouv != null)
				return false;
		} else if (!imagecouv.equals(other.imagecouv))
			return false;
		if (isbn != other.isbn)
			return false;
		if (langue == null) {
			if (other.langue != null)
				return false;
		} else if (!langue.equals(other.langue))
			return false;
		if (Double.doubleToLongBits(prixNeuf) != Double.doubleToLongBits(other.prixNeuf))
			return false;
		if (Double.doubleToLongBits(prixVente) != Double.doubleToLongBits(other.prixVente))
			return false;
		if (quantiteStock != other.quantiteStock)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

}
