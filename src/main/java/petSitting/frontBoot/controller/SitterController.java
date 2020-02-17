package petSitting.frontBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.model.ReponsePK;
import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;
import petSitting.frontBoot.repositories.ReponseRepository;
import petSitting.frontBoot.services.ReponseService;
import petSitting.frontBoot.services.SitterService;


	@Controller
	public class SitterController {
		
		@Autowired
		SitterService sitterService;
		
		
		@Autowired
		CompteRepository compteRepository;
		
		@Autowired
		AnnonceRepository annonceRepository;
		
		@Autowired
		ReponseRepository reponseRepository;
		@Autowired
		ReponseService reponseService;

		@GetMapping("sitter/postulerAnnonce") //  a changer a prés par post pour que je puisse voir l erreur par get/ce qu'on ecrit sur le navigateur , c'est l'url appelé sur le front
		public String AfficherAnnonces(Model model) {
			List<Annonce> annonces = annonceRepository.selectAllWithStatut0();
			Compte sitter = new Compte();
			Optional<Compte> opt = compteRepository.findById(100);
			if(opt.isPresent()) {
				sitter= opt.get();
			}
			model.addAttribute("compte", (Sitter)sitter);
			model.addAttribute("listAnnonces", annonces); //listAnnonces nom de la variable a recuperer en front , à toi de le nommer comme tu veux , annonces : la variable a mettre dand le model
			model.addAttribute("reponse", new Reponse());
			return "auth/sitter/postulerAnnonce";// le nom de la jsp
		}
		//@ModelAttribute("reponse")@RequestParam(name="numC") Integer numC,

		@PostMapping("sitter/postulerAnnonce")
		public String PostulerAnnonce(@ModelAttribute("reponse")Reponse reponse,@RequestParam(name="numA") Integer numA, @RequestParam(name="numC") Integer numC,BindingResult br,Model model) {
			
			Optional<Compte> opt1 = compteRepository.findById(numC);
			Optional<Annonce> opt2 = annonceRepository.findById(numA);	
			Compte c = new Compte();
			Annonce a = new Annonce();
		   if(opt1.isPresent()) {
			    c= opt1.get();
		   }
		   if(opt2.isPresent()) {
			    a = opt2.get();
		   }
			ReponsePK pk = new ReponsePK((Sitter) c, a);
			reponse.setKey(pk);
			
			reponseService.save(reponse);
			return("redirect:auth/menu");
			
		}

		

	@GetMapping("sitter/noterAnnonce")
	public String afficherAnnoncesTermines (@RequestParam(name="numC") Integer numC,Model model) {
		
		List<Annonce> annonces = annonceRepository.afficherAnnoncesTerminees(numC);
		model.addAttribute("list", annonces);
		model.addAttribute("annonce", new Annonce());
		
		return ("auth/sitter/noterP");
		
	}
	@PostMapping("sitter/noterAnnonce")
	public String noterAnnonce (@RequestParam(name="numA") Integer numA,Double note,@ModelAttribute("annonce")Annonce annonce,Model model) {
		System.out.println(annonce);
		
		
		Annonce a = new Annonce();
		Optional<Annonce> annonceTrouv = annonceRepository.findById(numA);
		 if(annonceTrouv.isPresent()) {
			    a= annonceTrouv.get();
		   }
		a.setNoteP(annonce.getNoteP());
		annonceRepository.save(a);
		
		return ("redirect:auth/menu");
		
	}
	
	
	
	//@PostMapping("/saveEleve")
	//public String saveEleve(@ModelAttribute("personne")@Valid Eleve personne,BindingResult br, Model model) {
//		return save (personne,br, model); 
	//}
	
	
//	@PostMapping("/sitter/saveReponse")
//	public String saveReponse(@ModelAttribute("reponse") Reponse reponse, Model model) {
//		reponseService.save(reponse);
//		model.addAttribute("numC", reponse.getKey().getCompte().getNumC());
//		return "redirect:/sitter/afficherAnnoncesBySitter";
//		
//	}
//	
	
//	public String save(Reponse reponse, BindingResult br, Model model) {
//		if (br.hasErrors())
//			return "sitter/postulerAnnonce";
//		if (reponse.getMessage() != null && reponse.getMessage().isEmpty()) {
//			reponse.setMessage(null);
//		}
//		reponseRepository.save(reponse);
//		
//		return "redirect:/menu";
//	}
//faut faire marcher save reponse
	
//	@GetMapping("/menu")
//	public ModelAndView menuProprio() {
//		Compte proprio = new Compte();
//		Optional<Compte> opt = compteRepository.findById(101);
//		if(opt.isPresent()) {
//			proprio= opt.get();
//		}
//		
//		return new ModelAndView("menu", "compte", (Proprio) proprio );
//	}
	
	
	
	
	
//@PostMapping("/saveEleve")
//public String saveEleve(@ModelAttribute("personne")@Valid Eleve personne,BindingResult br, Model model) {
//	return save (personne,br, model); 
//}


		
//		public String save(Personne personne, BindingResult br, Model model) {
//			
//			if (br.hasErrors())
//				return "personne/edit";
//			
//			if (personne.getSalle()!=null&&personne.getSalle().getNom().isEmpty()) {
//				
//				personne.setSalle(null);
//			}
//			
//			personneRepository.save(personne); 
//			return "redirect:/personne/list"; 
//		}
		
	
	
	
//	@PostMapping("/saveEleve")
//	public String saveEleve(@ModelAttribute("personne")@Valid Eleve personne,BindingResult br, Model model) {
//		return save (personne,br, model); 
//	}
//	
//	
//	@PostMapping("/saveFormateur")
//	//BindingResult faut le mettre juste a^res l on=bjet que vous valider et c est lui qui verifie si il est bien valide nptre objet qui a ete genere par valid si c est bon ou pas pr savoir le truc qui n a pas marche
//	public String saveFormateur(@ModelAttribute ("personne")@Valid Formateur personne,BindingResult br, Model model) {
//		return save (personne,br, model); 	
//	}
	
	
	



}
	
	
	
	

