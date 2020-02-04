package petSitting.frontBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.repositories.AnnonceRepository;

@Controller
public class SitterController {
	
	@Autowired
	AnnonceRepository annonceRepository;

	@GetMapping("sitter/postulerAnnonce") //  a changer a pr�s par post pour que je puisse voir l erreur par get/ce qu'on ecrit sur le navigateur , c'est l'url appel� sur le front
	public String AfficherAnnonces(Model model) {
		List<Annonce> annonces = annonceRepository.selectAllWithStatut0();
		
		model.addAttribute("listAnnonces", annonces);
		return "sitter/postulerAnnonce";// le nom de la jsp
	}

	
//	
//	@PostMapping("/postuler"){
//	public String PostulerAnnonce(@ModelAttribute Annonce a,Model model, (@RequestParam  Integer numC) {
//		model.addAttribute("annonce", a);
//		return null;
//
//	}


}
	
	

