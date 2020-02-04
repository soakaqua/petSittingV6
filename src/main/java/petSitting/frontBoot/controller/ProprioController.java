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
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.CompteRepository;
import petSitting.frontBoot.services.AnnonceService;

@Controller
@RequestMapping("/proprio")
public class ProprioController {

	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	AnnonceRepository annonceRepository;
	
	@Autowired
	AnnonceService annonceService;
	
	@GetMapping("/consulterAnnonces")
	public String reditectConsulterAnnonces(Integer numC, Model model) {	
		model.addAttribute("numC",numC);
		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprio(numC));
		return "proprio/consulterAnnonces";
	}
	
	@GetMapping("/modifierAnnonce")
	public String reditectModifierAnnonce(Integer numC, Model model) {
		model.addAttribute("numC",numC);
		return "proprio/modifierAnnonce";
	}
	
	@GetMapping("/publierAnnonce")
	public String reditectPublierAnnonce(Integer numC, Model model) {
		model.addAttribute("annonce",new Annonce());
		model.addAttribute("numC",numC);
		return "proprio/publierAnnonce";
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name="numA") Integer numA, Integer numC) {
		annonceRepository.deleteByNumA(numA);
		return new ModelAndView("redirect:/proprio/consulterAnnonces", "numC", numC);	
	}
	
	@GetMapping("/saveModif")
	public String saveModif(@ModelAttribute ("annonce") @Valid Annonce annonce, Integer numA, BindingResult br, Model model, HttpSession session) { 
		if(br.hasErrors())
			{return "proprio/publierAnnonce";}
		else {
			Optional<Annonce> opt=annonceRepository.findById(numA);
			Annonce a=null;
			if(opt.isPresent()) {
				a=opt.get();
				a.setNumC((Integer)session.getAttribute("numC"));
				a.setStatut(0);
				annonceService.save(a);
				}
			return "redirect:/proprio/consulterAnnonces?numC="+session.getAttribute("numC"); 
			}
	}	//   http://localhost:8080/petSitting_FrontV4/proprio/saveModif?numA=145&numC=101
	
	@GetMapping("/savePubli")
	public String savePubli(@ModelAttribute ("annonce") @Valid Annonce annonce, BindingResult br, Model model, HttpSession session) { 
		if(br.hasErrors())
			{return "proprio/modifierAnnonce";}
		else {
			annonce.setNumC((Integer)session.getAttribute("numC"));
			annonce.setStatut(0);
			annonceService.save(annonce);
			return "redirect:/proprio/consulterAnnonces?numC="+session.getAttribute("numC"); 
			}
	}
	//      http://localhost:8080/petSitting_FrontV4/proprio/consulterAnnonces?numC=101
	
	
	


}