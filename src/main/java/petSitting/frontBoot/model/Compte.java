package petSitting.frontBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name ="compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte",initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 1 table ! ajouter discriminatorColumn et discriminatorValue dans classes filles
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	private Integer numC;
	@Column(name ="cp", length = 15)
	private Integer cp;
	@Column(name ="mdp", length = 30)
	private String mdpC;
	@Column(name ="mail", length = 50)
	private String mail;
	@Column(name ="statut", length = 1)
	private int statut;
	@Column(name ="nom", length = 50)
	private String nom;
	@Column(name ="prenom", length = 50)
	private String prenom;
	@Version
	private int version;


	
	public Compte(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
		this.numC = numC;
		this.cp = cp;
		this.mdpC = mdpC;
		this.mail = mail;
		this.statut = 0;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Compte(String mail, String mdpC, Integer cp) {
		this.cp = cp;
		this.mdpC = mdpC;
		this.mail = mail;
		this.statut = 0;
	}
	
	

	public Compte() {
		
	}

	public Integer getNumC() {
		return numC;
	}
	public void setNumC(Integer numC) {
		this.numC = numC;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public String getMdpC() {
		return mdpC;
	}
	public void setMdpC(String mdpC) {
		this.mdpC = mdpC;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Compte [numC=" + numC + ", cp=" + cp + ", mdpC=" + mdpC + ", mail=" + mail + ", statut=" + statut + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numC == null) ? 0 : numC.hashCode());
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
		Compte other = (Compte) obj;
		if (numC == null) {
			if (other.numC != null)
				return false;
		} else if (!numC.equals(other.numC))
			return false;
		return true;
	}
	

	
	
	
	
	
	
	
//	public void gestCompte(Integer id) throws ClassNotFoundException, SQLException {
//		//Permet de modifier mdp, mail, adresses.
//		int choix = 0;
//		System.out.println("Bienvenue sur votre menu gestion de compte !");
//		System.out.println("Que voulez vous faire ?");
//		System.out.println("1 - Modifier votre mot de passe");
//		System.out.println("2 - Modifier votre mail");
//		System.out.println("3 - Modifier votre code postal");
//		
//		try {
//			choix = Main.saisieInt("Entrez le nombre correspondant � votre choix");
//		}catch(InputMismatchException e) {System.out.println("Merci de saisir un chiffre !");gestCompte(id);}
//		
//		DAOCompte daoC=new DAOCompte();
//		//try {
//		Compte c = daoC.selectById(id);
//
//		switch(choix)
//		{case 1: 
//			String str1 = Main.saisieString("Entrez votre nouveau mot de passe"); 
//			c.setMdpC(str1);
//			daoC.update(c);
//			break;
//		case 2: 
//			String str2 = Main.saisieString("Entrez votre nouveau mail"); 
//			c.setMail(str2);
//			daoC.update(c);
//			break;
//		case 3: 
//		int int1 = Main.saisieInt("Entrez votre nouveau code postal"); 
//		c.setCp(int1);
//		daoC.update(c);
//		break;
//		default : System.out.println("Choix invalide");gestCompte(id);
//		}
//		//}catch(Exception e) {System.out.println("PB gestion compte");}
//
//	}
	
	
}