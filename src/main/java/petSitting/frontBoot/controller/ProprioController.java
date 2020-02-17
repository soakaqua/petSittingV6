package petSitting.frontBoot.controller;

import java.util.Optional;

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
import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;
import petSitting.frontBoot.services.AnnonceService;

@Controller
@RequestMapping("/proprio")
public class ProprioController {

	//  http://localhost:8080/petsitting/proprio/consulterAnnonces?numC=10
	//  http://localhost:8080/petsitting/proprio/publierAnnonce?numC=10
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	AnnonceRepository annonceRepository;
	
	@Autowired
	AnnonceService annonceService;
	
	@GetMapping("/consulterAnnonces")
	public String redirectConsulterAnnonces(@RequestParam(name="numC") Integer numC, Model model) {	
		model.addAttribute("numC",numC);
		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprio(numC));
		return "auth/proprio/consulterAnnonces";
	}
	
	@GetMapping("/modifierAnnonce")
	public String modifierAnnonce(@RequestParam(name="numC") Integer numC, @RequestParam(name="numA") Integer numA, Model model) {
		Optional<Annonce> opt=annonceRepository.findById(numA);
		Annonce a=null;
		if(opt.isPresent()) {a=opt.get();} 
		return goEdit(a,model);
	}
	
	@GetMapping("/publierAnnonce")
	public String publierAnnonce(@RequestParam(name="numC") Integer numC, Model model) {
		return goEdit(new Annonce(),model);
	}
		
	private String goEdit(Annonce a, Model model) {
		model.addAttribute("annonce",a);
//		if (a.getTitre()!=null) {
//			return "auth/proprio/modifierAnnonce";
//		}
//		else {
//			return "auth/proprio/publierAnnonce";
//		}
		return "auth/proprio/modifierAnnonce";
	}

	@GetMapping("/save")
	private String save(@ModelAttribute ("annonce") @Valid Annonce annonce, Integer numC, BindingResult br, Model model, HttpSession session) {
		System.out.println(session.getAttribute("numC"));
		System.out.println(annonce.getProprio());
		System.out.println(annonce.getProprio().getNumC());
		if(br.hasErrors())
			{return "auth/proprio/modifierAnnonce";}
		else {
			Optional<Compte> opt = compteRepository.findById(numC);
			Compte p=new Proprio();
				if(opt.isPresent()) {p=opt.get();
//				annonce.getProprio().setNumC((Integer)session.getAttribute("numC"));
				annonce.setStatut(0);
				annonceService.save(annonce, (Proprio) p);
				} 
			
			return "redirect:/auth/proprio/consulterAnnonces?numC="+session.getAttribute("numC"); 
		}
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name="numA") Integer numA, @RequestParam(name="numC") Integer numC) {
		annonceRepository.deleteByNumA(numA);
		return new ModelAndView("redirect:/proprio/consulterAnnonces", "numC", numC);	
	}	
	
	

	


}