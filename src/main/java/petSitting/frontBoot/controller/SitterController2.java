package petSitting.frontBoot.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class SitterController2 {

	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	AnnonceRepository annonceRepository;
	
	@Autowired
	SitterService sitterService;
	
	@Autowired
	ReponseRepository reponseRepository;
	
	@Autowired
	ReponseService reponseService;
	
	@GetMapping("sitter/noterAnnonce")
	public String afficherAnnoncesTermines (Model model, HttpSession session) {
		
		List<Annonce> annonces = annonceRepository.afficherAnnoncesTerminees((Integer) session.getAttribute("numC"));
		model.addAttribute("list", annonces);
		model.addAttribute("annonce", new Annonce());
		
		return ("/auth/sitter/noterP");
		
	}
	@PostMapping("sitter/noterAnnonce")
	public String noterAnnonce (@RequestParam(name="numA") Integer numA,Double note,@ModelAttribute("annonce")Annonce annonce,Model model) {

		
		Annonce a = new Annonce();
		Optional<Annonce> annonceTrouv = annonceRepository.findById(numA);
		 if(annonceTrouv.isPresent()) {
			    a= annonceTrouv.get();
		   }
		a.setNoteP(annonce.getNoteP());
		annonceRepository.save(a);
		
		return ("redirect:/auth/menu");
	}
	
	//fonctionnel

	
	@GetMapping("/sitter/afficherAnnonces")
	public String afficherAnnonces(Model model) {
		model.addAttribute("annonces", annonceRepository.selectAllWithStatut0());
		return "/auth/sitter/afficherAnnonces";
	}
	
	
	@GetMapping("/sitter/postuler")
	public String createReponse(@RequestParam(name="numA") Integer numA, Model model, HttpSession session) {
		
		Optional<Compte> opt1 = compteRepository.findById((Integer) session.getAttribute("numC"));
		Optional<Annonce> opt2 = annonceRepository.findById(numA);	
		ReponsePK pk = new ReponsePK((Sitter) opt1.get(), opt2.get());
		
		Reponse reponse = new Reponse();
		reponse.setKey(pk);
		
		model.addAttribute("reponse", reponse);
		model.addAttribute("annonce", opt2.get());
		return "/auth/sitter/editReponse";
	}
	
	

	@GetMapping("/sitter/afficherAnnoncesBySitter")
	public String menuProprio(Model model, HttpSession session) {
		model.addAttribute("annonces", annonceRepository.selectAnnonceBySitter((Integer) session.getAttribute("numC")));
		model.addAttribute("reponse", sitterService.afficherReponseBySitterAndAnnonce((Integer) session.getAttribute("numC")));
		return "/auth/sitter/afficherAnnoncesBySitter" ;	
		}

	
	@GetMapping("/sitter/delete")
	public String deleteReponse(@RequestParam(name="numA") Integer numA, @RequestParam(name="numC") Integer numC, Model model) {
		Optional<Compte> opt1 = compteRepository.findById(numC);
		Optional<Annonce> opt2 = annonceRepository.findById(numA);	
		ReponsePK pk = new ReponsePK((Sitter) opt1.get(), opt2.get());
		reponseRepository.deleteById(pk);
		model.addAttribute("numC", pk.getSitter().getNumC());
		return "redirect:/sitter/afficherAnnoncesBySitter";
	}
	
	@GetMapping("/sitter/editReponse")
	public String editReponse(@RequestParam(name="numA") Integer numA, @RequestParam(name="numC") Integer numC, Model model) {
		
		Optional<Compte> opt1 = compteRepository.findById(numC);
		Optional<Annonce> opt2 = annonceRepository.findById(numA);	
		ReponsePK pk = new ReponsePK((Sitter) opt1.get(), opt2.get());
		
		
		model.addAttribute("reponse", reponseRepository.findById(pk).get());
		model.addAttribute("annonce", opt2.get());
		return "/auth/sitter/editReponse";
	}
	
	@GetMapping("/sitter/saveReponse")
	public String saveReponse(@ModelAttribute("reponse") Reponse reponse, Model model) {
			
		reponseService.save(reponse);
		model.addAttribute("numC", reponse.getKey().getSitter().getNumC());
		return "redirect:/sitter/afficherAnnoncesBySitter";

		
	}
	
}
