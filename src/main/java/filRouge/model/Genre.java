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
import javax.validation.constraints.Size;

@Entity
public class Genre implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_genre")
	private int idGenre;
	
	@Size(max = 20)
	@Column(name = "type_genre")
	private String typeGenre;
	
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
	private List<Ouvrage> ouvrages;

	public Genre()
	{
	
	}

	public int getIdGenre()
	{
		return idGenre;
	}

	public void setIdGenre(int idGenre)
	{
		this.idGenre = idGenre;
	}

	public String getTypeGenre()
	{
		return typeGenre;
	}

	public void setTypeGenre(String typeGenre)
	{
		this.typeGenre = typeGenre;
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
		result = prime * result + idGenre;
		result = prime * result + ((ouvrages == null) ? 0 : ouvrages.hashCode());
		result = prime * result + ((typeGenre == null) ? 0 : typeGenre.hashCode());
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
		Genre other = (Genre) obj;
		if (idGenre != other.idGenre)
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
