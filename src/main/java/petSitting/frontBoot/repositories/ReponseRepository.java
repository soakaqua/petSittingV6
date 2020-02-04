package petSitting.frontBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.model.ReponsePK;

public interface ReponseRepository extends JpaRepository<Reponse,ReponsePK> {

	public List<Reponse> selectReponsesRefusees(Integer numA, Integer numC);
	
	public List<Reponse> selectReponseByNumCNumA(Integer numA, Integer numC);
	
	
}
