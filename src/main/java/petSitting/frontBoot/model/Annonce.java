package petSitting.frontBoot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name="annonce")
@SequenceGenerator(name="seqAnnonce",sequenceName="seq_annonce",initialValue=100,allocationSize=1) 

@NamedQueries
({@NamedQuery(name="Annonce.selectAnnonceByProprioWhereStatut0",query="select distinct a from Annonce a left join fetch a.proprio prop where a.statut=0 and prop.numC=?1"),	
@NamedQuery(name="Annonce.selectAnnonceByProprio",query="select distinct a from Annonce a left join fetch a.proprio prop where prop.numC=?1"),
@NamedQuery(name="Annonce.afficherAnnoncesTerminees",query="select distinct a from Annonce a left join fetch a.proprio prop where a.statut=1 and prop.numC=?1"),
@NamedQuery(name="Annonce.selectAllWithStatut0",query="select a from Annonce a where a.statut=0"),
@NamedQuery(name="Annonce.selectAnnonceBySitter",query="select distinct a from Annonce a left join fetch a.reponse rep where rep.key.sitter.numC=?1"),
@NamedQuery(name="Annonce.selectAnnonceBySitterEnCours",query="select distinct a from Annonce a left join fetch a.reponse rep where rep.key.sitter.numC=?1 and a.statut=0"),
@NamedQuery(name="Annonce.selectAnnonceBySitterTerminee",query="select distinct a from Annonce a left join fetch a.reponse rep where rep.key.sitter.numC=?1 and a.statut=1")
//,@NamedQuery(name="Annonce.selectNoteSitter",query="select distinct noteS from Sitter s left join fetch s.annonce ann where ann.key.numC=?1"),
}) 

public class Annonce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqAnnonce") 
	private Integer numA ;
	
	@NotEmpty
	@Column(length=500,nullable=false)
	private String titre;
	
	@NotEmpty
	@Column(length=1000,nullable=false, name="message")
	private String message;
	
	@Column
	private Double noteP;
	
	@Column
	private Double noteS;
	
	@Column
	private Integer statut;
	
	@Column(name="key")
	@OneToMany(mappedBy="key.annonce")
	private Set<Annonce_Service> annonce_service;
	
	@Column(name="key")
	@OneToMany(mappedBy="key.annonce")
	private Set<Reponse> reponse;
	
	@ManyToOne
	//(cascade = {CascadeType.ALL})
	private Proprio proprio;
	
	@Version
	private int version;
	
	public Annonce() {
		
	}
	
	public Annonce(String titre, String message, Proprio proprio, Set<Annonce_Service> listService) {
		this.titre = titre;
		this.message = message;
		this.statut = 0;
		this.annonce_service = null;
		this.proprio = proprio;
	}
	
	public Annonce(Integer numA, String titre, String message, Set<Annonce_Service> listService) {
		this.numA = numA;
		this.titre = titre;
		this.message = message;
		this.statut = 0;
		this.annonce_service = null;
	} 

	public Annonce(Integer numA, String titre, String message, Double noteP, Double noteS, int statut, Proprio proprio, 
			Set<Annonce_Service>  annonce_service) {
		this.numA = numA;
		this.titre = titre;
		this.message = message;
		this.noteP = noteP;
		this.noteS = noteS;
		this.statut = 0;
		this.annonce_service = null;
		this.proprio = proprio;
	}


	public Integer getNumA() {
		return numA;
	}

	public void setNumA(Integer numA) {
		this.numA = numA;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getNoteP() {
		return noteP;
	}

	public void setNoteP(Double noteP) {
		this.noteP = noteP;
	}

	public Double getNoteS() {
		return noteS;
	}

	public void setNoteS(Double noteS) {
		this.noteS = noteS;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public Set<Annonce_Service> getAnnonce_service() {
		return annonce_service;
	}

	public void setAnnonce_service(Set<Annonce_Service> annonce_service) {
		this.annonce_service = annonce_service;
	}

	public Set<Reponse> getReponse() {
		return reponse;
	}

	public void setReponse(Set<Reponse> reponse) {
		this.reponse = reponse;
	}

	public Proprio getProprio() {
		return proprio;
	}

	public void setProprio(Proprio proprio) {
		this.proprio = proprio;
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
		result = prime * result + numA;
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
		Annonce other = (Annonce) obj;
		if (numA != other.numA)
			return false;
		return true;
	}
	
	
	
}
