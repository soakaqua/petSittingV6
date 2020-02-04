package petSitting.frontBoot.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "reponse")

@NamedQueries({
	@NamedQuery(name="Reponse.selectReponsesRefusees",query="select r from Reponse r left join fetch r.key.annonce ann left join fetch r.key.sitter sit where ann.numA=?1 and sit.numC!=?2"),
	@NamedQuery(name="Reponse.selectReponseByNumCNumA",query="select r from Reponse r left join fetch r.key.annonce ann left join fetch r.key.sitter sit where ann.numA=?1 and sit.numC=?2"),
})

public class Reponse {
	
	@EmbeddedId
	private ReponsePK key;
	
	@Column(name = "message", length =200 )
	private String message;
	
	@Version
	private int version;
	
	public Reponse() {
		
	}

	public Reponse(ReponsePK key, String message) {
		this.key = key;
		this.message = message;
	}

	public ReponsePK getKey() {
		return key;
	}

	public void setKey(ReponsePK key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Reponse other = (Reponse) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
	
}
