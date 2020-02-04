package petSitting.frontBoot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Annonce_ServicePK;

public interface Annonce_ServiceRepository extends JpaRepository<Annonce_Service, Annonce_ServicePK>  {
	
}
