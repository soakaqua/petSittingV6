//package petSitting.frontBoot.controller;
//
//import java.util.Optional;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import petSitting.frontBoot.model.Annonce;
//import petSitting.frontBoot.model.Proprio;
//import petSitting.frontBoot.repositories.AnnonceRepository;
//import petSitting.frontBoot.repositories.CompteRepository;
//import petSitting.frontBoot.services.AnnonceService;
//
//@Controller
//@RequestMapping("/proprio")
//public class ProprioController2 {
//
//	//  http://localhost:8080/petsitting/proprio/consulterAnnonces?numC=10
//	//  http://localhost:8080/petsitting/proprio/publierAnnonce?numC=10
//	
//	
//	@Autowired
//	CompteRepository compteRepository;
//	
//	@Autowired
//	AnnonceRepository annonceRepository;
//	
//	@Autowired
//	AnnonceService annonceService;
//
//	
//	@GetMapping("/consulterAnnonces")
//	public String redirectConsulterAnnonces(@RequestParam(name="numC") Integer numC, Model model) {	
//		model.addAttribute("numC",numC);
//		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprio(numC));
//		return "auth/proprio/consulterAnnonces";
//	}
//
//	@GetMapping("/modifierAnnonce")
//	public String redirectModifierAnnonce(Integer numC, Model model) {	
//		model.addAttribute("numC",numC);
//		return "auth/proprio/modifierAnnonce";
//	}
//	
//	@GetMapping("/publierAnnonce")
//	public String redirectPublierAnnonce(Integer numC, Model model) {	
//		Annonce a = new Annonce();
//		model.addAttribute("annonce",a);
//		//model.addAttribute("annonce",new Annonce());
//		model.addAttribute("numC",numC);
//		return "auth/proprio/publierAnnonce";
//	}
//
////	@GetMapping("/modifierAnnonce")
////	public String redirectModifierAnnonce(@ModelAttribute Annonce annonce, @RequestParam(name="numC") Integer numC,  Model model) {
////		model.addAttribute("numC",numC);
////		model.addAttribute("annonce",annonce);
////		return "auth/proprio/modifierAnnonce";
////	}
////	
////	@GetMapping("/publierAnnonce")
////	public String redirectPublierAnnonce(@ModelAttribute Annonce annonce, @RequestParam(name="numC") Integer numC,  Model model) {
////		model.addAttribute("numC",numC);
////		model.addAttribute("annonce",annonce);
////		return "auth/proprio/publierAnnonce";
////	}
//	
//	
////	@GetMapping("/consulterAnnonces")
////	public String redirectConsulterAnnonces(Integer numC, Model model) {	
////		model.addAttribute("numC",numC);
////		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprio(numC));
////		return "auth/proprio/consulterAnnonces";
////	}
////	
////	@GetMapping("/modifierAnnonce")
////	public String redirectModifierAnnonce(Integer numC, Model model) {
////		model.addAttribute("numC",numC);
////		return "auth/proprio/modifierAnnonce";
////	}
////	
////	@GetMapping("/publierAnnonce")
////	public String redirectPublierAnnonce(Integer numC, Model model, Annonce annonce) {
////		model.addAttribute("annonce",new Annonce());
////		model.addAttribute("numC",numC);
////		return "auth/proprio/publierAnnonce";
////	}
//
//	@GetMapping("/delete")
//	public ModelAndView delete(@RequestParam(name="numA") Integer numA, @RequestParam(name="numC") Integer numC) {
//		annonceRepository.deleteByNumA(numA);
//		return new ModelAndView("redirect:/proprio/consulterAnnonces", "numC", numC);	
//	}
//	
////	@GetMapping("/saveModif")
////	public String saveModif(@ModelAttribute ("annonce") @Valid Annonce annonce, Integer numA, BindingResult br, Model model, HttpSession session) { 
////		if(br.hasErrors())
////			{return "proprio/publierAnnonce";}
////		else {
////			Optional<Annonce> opt=annonceRepository.findById(numA);
////			Annonce a=null;
////			if(opt.isPresent()) {
////				a=opt.get();
////				a.getProprio().setNumC((Integer)session.getAttribute("numC"));
////				a.setStatut(0);
////				annonceService.save(a);
////				}
////			model.addAttribute("annonce",annonce);
////			return "redirect:/proprio/consulterAnnonces?numC="+session.getAttribute("numC"); 
////			}
////	}
//	
//	@GetMapping("/savePubli")
//	public String savePubli(@ModelAttribute ("annonce") @Valid Annonce annonce, BindingResult br, Model model, HttpSession session) { 
//		if(br.hasErrors())
//			{return "proprio/modifierAnnonce";}
//		else {
//			annonce.getProprio().setNumC((Integer)session.getAttribute("numC"));
//			annonce.setStatut(0);
//			annonceService.save(annonce);
//			return "redirect:/proprio/consulterAnnonces?numC="+session.getAttribute("numC"); 
//			}
//	}
//	
//	
//	
//
//
//}