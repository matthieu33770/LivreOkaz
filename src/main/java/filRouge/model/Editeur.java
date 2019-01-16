package filRouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

public class Editeur implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_editeur")
	private int idEditeur;
	
	@Size(max = 20)
	@Column(name = "nom_editeur")
	private String nomEditeur;
	
	@ManyToOne
	@JoinColumn(name="id_ouvrage")
	private Ouvrage ouvrage;
	
	public Editeur()
	{
	
	}

	public int getIdEditeur() {
		return idEditeur;
	}

	public void setIdEditeur(int idEditeur) {
		this.idEditeur = idEditeur;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEditeur;
		result = prime * result + ((nomEditeur == null) ? 0 : nomEditeur.hashCode());
		result = prime * result + ((ouvrage == null) ? 0 : ouvrage.hashCode());
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
		Editeur other = (Editeur) obj;
		if (idEditeur != other.idEditeur)
			return false;
		if (nomEditeur == null) {
			if (other.nomEditeur != null)
				return false;
		} else if (!nomEditeur.equals(other.nomEditeur))
			return false;
		if (ouvrage == null) {
			if (other.ouvrage != null)
				return false;
		} else if (!ouvrage.equals(other.ouvrage))
			return false;
		return true;
	}

	
	
}
