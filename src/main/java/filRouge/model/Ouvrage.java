package filRouge.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Ouvrage implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_ouvrage")
	private int idOuvrage;
	
	@Size(max = 50)
	private String titre;
	
	@Size(max = 13)
	private int isbn;
	
	@Size(max = 100)
	@Column(name = "image_couv")
	private String imagecouv;
	
	@Size(max = 255)
	private String sujet;
	
	@Size(max = 255)
	private String description;
	
	@Size(max = 10)
	private String langue;
	
	@Size(max = 4)
	@Column(name = "annee_parution")
	private int anneeParution;
	
	@Column(name = "quantite_stock")
	private int quantiteStock;
	
	@Column(name = "prix_neuf")
	private double prixNeuf;
	
	@Column(name = "prix_vente")
	private double prixVente;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_auteur", joinColumns = @JoinColumn(name = "id_ouvrage"), inverseJoinColumns = @JoinColumn(name = "id_auteur"))
	private List<Auteur> auteurs;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_editeur", joinColumns = @JoinColumn(name = "id_ouvrage"), inverseJoinColumns = @JoinColumn(name = "id_editeur"))
	private List<Editeur> editeurs;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_auteur", joinColumns = @JoinColumn(name = "id_ouvrage"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private List<Genre> genres;
	
	public Ouvrage()
	{
	
	}

	public Ouvrage(int idOuvrage, @Size(max = 50) String titre, @Size(max = 13) int isbn,
			@Size(max = 100) String imagecouv, @Size(max = 255) String sujet, @Size(max = 255) String description,
			@Size(max = 10) String langue, @Size(max = 4) int anneeParution, int quantiteStock, double prixNeuf,
			double prixVente, List<Auteur> auteurs, List<Editeur> editeurs, List<Genre> genres)
	{
		super();
		this.idOuvrage = idOuvrage;
		this.titre = titre;
		this.isbn = isbn;
		this.imagecouv = imagecouv;
		this.sujet = sujet;
		this.description = description;
		this.langue = langue;
		this.anneeParution = anneeParution;
		this.quantiteStock = quantiteStock;
		this.prixNeuf = prixNeuf;
		this.prixVente = prixVente;
		this.auteurs = auteurs;
		this.editeurs = editeurs;
		this.genres = genres;
	}

	public int getIdOuvrage()
	{
		return idOuvrage;
	}

	public void setIdOuvrage(int idOuvrage)
	{
		this.idOuvrage = idOuvrage;
	}

	public String getTitre()
	{
		return titre;
	}

	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	public int getIsbn()
	{
		return isbn;
	}

	public void setIsbn(int isbn)
	{
		this.isbn = isbn;
	}

	public String getImagecouv()
	{
		return imagecouv;
	}

	public void setImagecouv(String imagecouv)
	{
		this.imagecouv = imagecouv;
	}

	public String getSujet()
	{
		return sujet;
	}

	public void setSujet(String sujet)
	{
		this.sujet = sujet;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLangue()
	{
		return langue;
	}

	public void setLangue(String langue)
	{
		this.langue = langue;
	}

	public int getAnneeParution()
	{
		return anneeParution;
	}

	public void setAnneeParution(int anneeParution)
	{
		this.anneeParution = anneeParution;
	}

	public int getQuantiteStock()
	{
		return quantiteStock;
	}

	public void setQuantiteStock(int quantiteStock)
	{
		this.quantiteStock = quantiteStock;
	}

	public double getPrixNeuf()
	{
		return prixNeuf;
	}

	public void setPrixNeuf(double prixNeuf)
	{
		this.prixNeuf = prixNeuf;
	}

	public double getPrixVente()
	{
		return prixVente;
	}

	public void setPrixVente(double prixVente)
	{
		this.prixVente = prixVente;
	}

	public List<Auteur> getAuteurs()
	{
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs)
	{
		this.auteurs = auteurs;
	}

	public List<Editeur> getEditeurs()
	{
		return editeurs;
	}

	public void setEditeurs(List<Editeur> editeurs)
	{
		this.editeurs = editeurs;
	}

	public List<Genre> getGenres()
	{
		return genres;
	}

	public void setGenres(List<Genre> genres)
	{
		this.genres = genres;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeParution;
		result = prime * result + ((auteurs == null) ? 0 : auteurs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((editeurs == null) ? 0 : editeurs.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
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
		result = prime * result + ((sujet == null) ? 0 : sujet.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		if (anneeParution != other.anneeParution)
			return false;
		if (auteurs == null) {
			if (other.auteurs != null)
				return false;
		} else if (!auteurs.equals(other.auteurs))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (editeurs == null) {
			if (other.editeurs != null)
				return false;
		} else if (!editeurs.equals(other.editeurs))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
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
		if (sujet == null) {
			if (other.sujet != null)
				return false;
		} else if (!sujet.equals(other.sujet))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	
	
	
}
