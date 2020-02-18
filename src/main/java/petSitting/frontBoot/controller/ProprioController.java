package petSitting.frontBoot.controller;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;
import petSitting.frontBoot.repositories.ReponseRepository;
import petSitting.frontBoot.repositories.ServiceRepository;
import petSitting.frontBoot.services.AnnonceService;
import petSitting.frontBoot.services.ProprioService;

@Controller
@RequestMapping("/proprio")
public class ProprioController {

	// http://localhost:8080/petsitting/proprio/consulterAnnonces?numC=10
	// http://localhost:8080/petsitting/proprio/publierAnnonce?numC=10

	@Autowired
	CompteRepository compteRepository;

	@Autowired
	AnnonceRepository annonceRepository;

	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	ReponseRepository reponseRepository;

	@Autowired
	AnnonceService annonceService;
	
	@Autowired
	private ProprioService proprioService;

	@GetMapping("/consulterAnnonces")
	public String consulterAnnonces(Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		model.addAttribute("numC", numC);
		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprio(numC));
		return "auth/proprio/consulterAnnonces";
	}

	@GetMapping("/modifierAnnonce")
	public String modifierAnnonce(@RequestParam(name = "numA") Integer numA, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		Optional<Annonce> opt = annonceRepository.findById(numA);
		Annonce a = null;
		if (opt.isPresent()) {
			a = opt.get();
		}
		return goEdit(a, model, session);
	}

	@GetMapping("/publierAnnonce")
	public String publierAnnonce(Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		return goEdit(new Annonce(), model, session);
	}

	private String goEdit(Annonce a, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		model.addAttribute("annonce", a);
		//model.addAttribute("services", serviceRepository.findAll());
		
//		if (a.getTitre()!=null) {
//			return "auth/proprio/modifierAnnonce";
//		}
//		else {
//			return "auth/proprio/publierAnnonce";
//		}
		return "auth/proprio/modifierAnnonce";
		
	}

	@GetMapping("/save")
	private String save(@ModelAttribute("annonce") @Valid Annonce annonce, BindingResult br, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		System.out.println(session.getAttribute("numC"));
		System.out.println(annonce.getProprio());
		if (br.hasErrors()) {
			return "auth/proprio/modifierAnnonce";
		} else {
			Optional<Compte> opt = compteRepository.findById(numC);
			Compte p = new Proprio();
			if (opt.isPresent()) {
				p = opt.get();
				annonce.setStatut(0);
				Set<Annonce_Service> ListeServices = annonce.getAnnonce_service();
//				for(int i;;i++) {
//					Annonce_Service -> i;
//					ListeServices.add(i);
//				}
				
				annonceService.save(annonce, (Proprio) p);
			}
			return "redirect:/proprio/consulterAnnonces";
		}
	}

	@GetMapping("/afficherReponses")
	public String afficherReponses(@RequestParam(name = "numA") Integer numA, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		model.addAttribute("numC", numC);
		model.addAttribute("reponses", reponseRepository.selectReponseByNumA(numA));
		return "auth/proprio/afficherReponses";
	}
	
	@GetMapping("/validerSitter")
	public String validerSitter(@RequestParam(name = "numA") Integer numA, @RequestParam(name = "numC") Integer numC, Model model, HttpSession session) {
		//ATTENTION ICI NUMC EST LE NUMERO DU SITTER
		proprioService.validerSitter(numA, numC);
		return "redirect:/proprio/consulterAnnonces";
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "numA") Integer numA, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		annonceRepository.deleteByNumA(numA);
		return new ModelAndView("redirect:/proprio/consulterAnnonces", "numC", numC);
	}

}