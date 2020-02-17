package petSitting.frontBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Sitter;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	
	public List<Sitter> selectSittersByReponseValidee(Integer numA);
	
	public List<Compte> selectCompteByMail(String mail);
	
	
}
