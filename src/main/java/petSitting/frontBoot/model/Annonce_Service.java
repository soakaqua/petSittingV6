package petSitting.frontBoot.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="annonce_service")
public class Annonce_Service {
	
	@EmbeddedId //erreur � ignorer
	private Annonce_ServicePK key;
	@Version
	private int version;
	
	public Annonce_Service() {
	}

	public Annonce_Service(Annonce_ServicePK key, int version) {
		super();
		this.key = key;
		this.version = version;
	}

	public Annonce_ServicePK getKey() {
		return key;
	}

	public void setKey(Annonce_ServicePK key) {
		this.key = key;
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
		result = prime * result + version;
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
		Annonce_Service other = (Annonce_Service) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	
}
