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
	private long idRole;
	
	@Size(max = 10)
	@Column(name="fonction")
	private String fonction;

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
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

	public Role(long idRole, @Size(max = 10) String fonction) {
		this.idRole = idRole;
		this.fonction = fonction;
	}

	public Role(@Size(max = 10) String fonction) {
		this.fonction = fonction;
	}
}
