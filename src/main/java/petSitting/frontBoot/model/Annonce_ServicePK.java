package petSitting.frontBoot.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class Annonce_ServicePK implements Serializable{

	@ManyToOne
	@JoinColumn(name="annonce_id", foreignKey = @ForeignKey(name="annonce_service_annonce_id_fk")) 
	private Annonce annonce;
	@ManyToOne
	@JoinColumn(name="service_id", foreignKey = @ForeignKey(name="annonce_service_service_id_fk")) 
	private Service service;


	public Annonce_ServicePK() {

	}


	public Annonce_ServicePK(Annonce annonce, Service service) {
		this.annonce = annonce;
		this.service = service;
	}


	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonce == null) ? 0 : annonce.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		Annonce_ServicePK other = (Annonce_ServicePK) obj;
		if (annonce == null) {
			if (other.annonce != null)
				return false;
		} else if (!annonce.equals(other.annonce))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}
	
	
	
}
