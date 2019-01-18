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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_genre")
	private Integer idGenre;

	@Column(name = "type_genre")
	private String typeGenre;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
	private List<Ouvrage> ouvrages;

	public Genre()
	{
	
	}

	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getTypeGenre() {
		return typeGenre;
	}

	public void setTypeGenre(String typeGenre) {
		this.typeGenre = typeGenre;
	}

	public List<Ouvrage> getOuvrages() {
		return ouvrages;
	}

	public void setOuvrages(List<Ouvrage> ouvrages) {
		this.ouvrages = ouvrages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenre == null) ? 0 : idGenre.hashCode());
		result = prime * result + ((ouvrages == null) ? 0 : ouvrages.hashCode());
		result = prime * result + ((typeGenre == null) ? 0 : typeGenre.hashCode());
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
		Genre other = (Genre) obj;
		if (idGenre == null) {
			if (other.idGenre != null)
				return false;
		} else if (!idGenre.equals(other.idGenre))
			return false;
		if (ouvrages == null) {
			if (other.ouvrages != null)
				return false;
		} else if (!ouvrages.equals(other.ouvrages))
			return false;
		if (typeGenre == null) {
			if (other.typeGenre != null)
				return false;
		} else if (!typeGenre.equals(other.typeGenre))
			return false;
		return true;
	}

	
}
