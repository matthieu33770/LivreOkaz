package filRouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editeur implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_editeur")
	private Integer idEditeur;

	@Column(name = "nom_editeur")
	private String nomEditeur;
	
	public Editeur()
	{
	
	}

	public Integer getIdEditeur() {
		return idEditeur;
	}

	public void setIdEditeur(Integer idEditeur) {
		this.idEditeur = idEditeur;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEditeur == null) ? 0 : idEditeur.hashCode());
		result = prime * result + ((nomEditeur == null) ? 0 : nomEditeur.hashCode());
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
		if (idEditeur == null) {
			if (other.idEditeur != null)
				return false;
		} else if (!idEditeur.equals(other.idEditeur))
			return false;
		if (nomEditeur == null) {
			if (other.nomEditeur != null)
				return false;
		} else if (!nomEditeur.equals(other.nomEditeur))
			return false;
		return true;
	}
	
	
	
}
