package petSitting.frontBoot.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries({
@NamedQuery(name="Sitter.selectSittersByReponseValidee",query="select distinct s from Sitter s left join fetch s.reponses rep where rep.key.annonce.numA=?1")
})

@Entity
@DiscriminatorValue("S")
public class Sitter extends Compte {

	@OneToMany(mappedBy = "key.sitter") //erreur bidon ici
	private Set<Reponse> reponses;
	
	public Sitter(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}

	public Sitter() {

	}

	
}
