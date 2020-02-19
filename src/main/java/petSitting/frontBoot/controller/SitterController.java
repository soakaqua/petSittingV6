package petSitting.frontBoot.controller;

import java.util.ArrayList;
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
import petSitting.frontBoot.services.AnnonceService;
import petSitting.frontBoot.services.ReponseService;
import petSitting.frontBoot.services.SitterService;

@Controller
public class SitterController {

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
	
	@Autowired
	AnnonceService annonceService;

	@GetMapping("sitter/historiqueAnnonces")
	public String afficherAnnoncesTermines (Model model, HttpSession session) {

		model.addAttribute("annonces", annonceRepository.selectAnnonceBySitterTerminee((Integer) session.getAttribute("numC")));

		List<Annonce> lstA = new ArrayList<Annonce>();
		lstA = annonceRepository.selectAnnonceBySitterTerminee((Integer) session.getAttribute("numC"));
		List<Reponse> lstR = new ArrayList<Reponse>();
		for (int i = 0; i< lstA.size();i++) {
			lstR.add((Reponse) reponseRepository.selectReponseByNumCNumA(lstA.get(i).getNumA(),(Integer) session.getAttribute("numC") ).get(0));
		}
		model.addAttribute("reponse", lstR);
		
		return ("/auth/sitter/afficherAnnoncesBySitterTerminees");
	}
	
	@PostMapping("sitter/noterAnnonce")
	public String noterAnnonce (@RequestParam(name="numA") Integer numA,@RequestParam(name="noteP") Integer noteP , Model model) {
		Annonce a = new Annonce();
		Optional<Annonce> annonceTrouv = annonceRepository.findById(numA);
		if(annonceTrouv.isPresent()) {
			a= annonceTrouv.get();
		}
		a.setNoteP((double) noteP);
		annonceRepository.save(a);
		
		return ("redirect:/sitter/historiqueAnnonces");
	}



	@GetMapping("/sitter/afficherAnnonces")
	public String afficherAnnonces(Model model) {
		model.addAttribute("annonces", annonceRepository.selectAllWithStatut0());
		List<Annonce> lstA = new ArrayList<Annonce>();
		lstA =  annonceRepository.selectAllWithStatut0();
		
		List<Double> lstM = new ArrayList<Double>();
		for(int i =0 ; i< lstA.size(); i++) {
			lstM.add(annonceService.moyenneProprio(lstA.get(i).getProprio().getNumC())) ;
		}
		model.addAttribute("moyenneP", lstM);
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
