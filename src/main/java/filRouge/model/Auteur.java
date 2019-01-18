package filRouge.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Auteur implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_auteur")
	private int idAuteur;

	@Column(name = "nom_auteur")
	private String nomAuteur;

	@Column(name = "prenom_auteur")
	private String prenomAuteur;
	
	@ManyToMany(mappedBy = "auteurs", cascade = CascadeType.PERSIST)
	private List<Ouvrage> ouvrages;

	public Auteur()
	{
	
	}

	public int getIdAuteur()
	{
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur)
	{
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur()
	{
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur)
	{
		this.nomAuteur = nomAuteur;
	}

	public String getPrenomAuteur()
	{
		return prenomAuteur;
	}

	public void setPrenomAuteur(String prenomAuteur)
	{
		this.prenomAuteur = prenomAuteur;
	}

	public List<Ouvrage> getOuvrages()
	{
		return ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages)
	{
		this.ouvrages = ouvrages;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuteur;
		result = prime * result + ((nomAuteur == null) ? 0 : nomAuteur.hashCode());
		result = prime * result + ((ouvrages == null) ? 0 : ouvrages.hashCode());
		result = prime * result + ((prenomAuteur == null) ? 0 : prenomAuteur.hashCode());
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
		Auteur other = (Auteur) obj;
		if (idAuteur != other.idAuteur)
			return false;
		if (nomAuteur == null) {
			if (other.nomAuteur != null)
				return false;
		} else if (!nomAuteur.equals(other.nomAuteur))
			return false;
		if (ouvrages == null) {
			if (other.ouvrages != null)
				return false;
		} else if (!ouvrages.equals(other.ouvrages))
			return false;
		if (prenomAuteur == null) {
			if (other.prenomAuteur != null)
				return false;
		} else if (!prenomAuteur.equals(other.prenomAuteur))
			return false;
		return true;
	}
	
	
}
