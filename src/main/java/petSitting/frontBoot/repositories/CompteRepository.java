package petSitting.frontBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Sitter;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	
	public List<Sitter> selectSittersByReponseValidee(Integer numA);
	

	
	
}
