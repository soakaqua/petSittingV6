package petSitting.frontBoot.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ReponsePK implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "sitter_numc", foreignKey =@ForeignKey(name="reponse_sitter_numc_fk"))
	private Sitter sitter;
	
	@ManyToOne
	@JoinColumn(name ="annonce_numa", foreignKey = @ForeignKey(name ="reponse_annonce_numa_fk"))
	private Annonce annonce;
	
	public ReponsePK() {
		
	}

	public ReponsePK(Sitter sitter, Annonce annonce) {
		this.sitter = sitter;
		this.annonce = annonce;
	}



	public Sitter getSitter() {
		return sitter;
	}

	public void setSitter(Sitter sitter) {
		this.sitter = sitter;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonce == null) ? 0 : annonce.hashCode());
		result = prime * result + ((sitter == null) ? 0 : sitter.hashCode());
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
		ReponsePK other = (ReponsePK) obj;
		if (annonce == null) {
			if (other.annonce != null)
				return false;
		} else if (!annonce.equals(other.annonce))
			return false;
		if (sitter == null) {
			if (other.sitter != null)
				return false;
		} else if (!sitter.equals(other.sitter))
			return false;
		return true;
	}
	
	
	
	
	
	
}
