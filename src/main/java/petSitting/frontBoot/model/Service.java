package petSitting.frontBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "service")
@SequenceGenerator(name="seqService",sequenceName="seq_service",initialValue=100,allocationSize=1) 
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqService")
	private Integer numSer;
	@Column (length = 500, nullable=false)
	private String nomSer;
	@Column (length = 5, nullable=false)
	double prix;
	@Version
	private int version;
	
	public Service() {
	}

	public Service(Integer numSer, String nomSer, double prix, int version) {
		this.numSer = numSer;
		this.nomSer = nomSer;
		this.prix = prix;
		this.version = version;
	}

	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getNomSer() {
		return nomSer;
	}
	public Integer getNumSer() {
		return numSer;
	}
	public void setNumSer(Integer numSer) {
		this.numSer = numSer;
	}
	public void setNomSer(String nomSer) {
		this.nomSer = nomSer;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numSer == null) ? 0 : numSer.hashCode());
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
		Service other = (Service) obj;
		if (numSer == null) {
			if (other.numSer != null)
				return false;
		} else if (!numSer.equals(other.numSer))
			return false;
		return true;
	}





	
	
	
	
	
}