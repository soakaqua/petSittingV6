package petSitting.frontBoot.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import petSitting.frontBoot.model.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
 
	
	//NAMED QUERIES DANS ANNONCE
	public List<Annonce> selectAnnonceByProprio(Integer numC);
	public List<Annonce> afficherAnnoncesTerminees(Integer numC);
	public List<Annonce> selectAnnonceBySitter(Integer numC);
	public List<Annonce> selectAllWithStatut0();
	

	//public List<Integer> selectNoteSitter(Integer numC);
	
	public List<Annonce>findAllByNumA(Integer numA);
	
	@Transactional
	public void deleteByNumA(Integer numA);
	

}






