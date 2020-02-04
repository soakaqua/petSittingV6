package petSitting.frontBoot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaContext;


@Entity
@DiscriminatorValue("P")
public class Proprio extends Compte {

	@OneToMany
	@JoinColumn(name="proprio_annonce",foreignKey=@ForeignKey(name="proprio_annonce_fk"))
	private Set<Annonce> annonces;	
	
	public Proprio(Integer numC, Integer cp, String mdpC, String mail, String nom, String prenom) {
	}
	
	public Proprio() {	
	}

}
