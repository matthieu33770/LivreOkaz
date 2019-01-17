package filRouge.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Role implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_role")
	private Integer idRole;
	
	@Size(max = 20)
	@Column(name="fonction")
	private String fonction;
	
	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Role() {
	}

	public Role(Integer idRole, String fonction) {
		this.idRole = idRole;
		this.fonction = fonction;
	}

	public Role(String fonction) {
		this.fonction = fonction;
	}
}
