package filRouge.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
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
	
	public Editeur()
	{
	
	}
	
	

	public Editeur(@Size(max = 20) String nomEditeur) {
		super();
		this.nomEditeur = nomEditeur;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEditeur;
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
		if (idEditeur != other.idEditeur)
			return false;
		if (nomEditeur == null) {
			if (other.nomEditeur != null)
				return false;
		} else if (!nomEditeur.equals(other.nomEditeur))
			return false;
		return true;
	}



	
	
}
