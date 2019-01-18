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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Ouvrage implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_ouvrage")
	private Integer idOuvrage;
	
	private String titre;
	
	private String isbn;
	
	@Column(name = "image_couv")
	private String imagecouv;
	
	private String sujet;
	
	private String description;
	
	private String langue;
	
	@Column(name = "annee_parution")
	private int anneeParution;
	
	@Column(name = "quantite_stock")
	private int quantiteStock;
	
	@Column(name = "prix_neuf")
	private double prixNeuf;
	
	@Column(name = "prix_vente")
	private double prixVente;
	
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_auteur", joinColumns = @JoinColumn(name = "id_ouvrage"), inverseJoinColumns = @JoinColumn(name = "id_auteur"))
	private List<Auteur> auteurs;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idEditeur")
	private Editeur editeur;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ouvrage_genre", joinColumns = @JoinColumn(name = "id_ouvrage"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private List<Genre> genres;
	
	public Ouvrage()
	{
	
	}

	public Ouvrage(Integer idOuvrage, String titre, String isbn, String imagecouv, String sujet, String description,
			String langue, int anneeParution, int quantiteStock, double prixNeuf, double prixVente,
			List<Auteur> auteurs, Editeur editeur, List<Genre> genres) {
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
		this.editeur = editeur;
		this.genres = genres;
	}

	public Integer getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(Integer idOuvrage) {
		this.idOuvrage = idOuvrage;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getImagecouv() {
		return imagecouv;
	}

	public void setImagecouv(String imagecouv) {
		this.imagecouv = imagecouv;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
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

	public List<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(List<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anneeParution;
		result = prime * result + ((auteurs == null) ? 0 : auteurs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((editeur == null) ? 0 : editeur.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + ((idOuvrage == null) ? 0 : idOuvrage.hashCode());
		result = prime * result + ((imagecouv == null) ? 0 : imagecouv.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		if (editeur == null) {
			if (other.editeur != null)
				return false;
		} else if (!editeur.equals(other.editeur))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (idOuvrage == null) {
			if (other.idOuvrage != null)
				return false;
		} else if (!idOuvrage.equals(other.idOuvrage))
			return false;
		if (imagecouv == null) {
			if (other.imagecouv != null)
				return false;
		} else if (!imagecouv.equals(other.imagecouv))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
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
