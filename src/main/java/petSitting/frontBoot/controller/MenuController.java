package petSitting.frontBoot.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.CompteRepository;


@Controller
public class MenuController {
	
	@Autowired
	CompteRepository compteRepository;
	
	

	
	@GetMapping("/auth/menu")
	public String menu(Authentication authentication, HttpSession session) {
		
		String currentUserName = authentication.getName();
		session.setAttribute("numC", compteRepository.selectCompteByMail(currentUserName).get(0).getNumC());
		if(compteRepository.selectCompteByMail(currentUserName).get(0) instanceof Sitter) {
			session.setAttribute("typeC", "sitter" );
		}
		else if (compteRepository.selectCompteByMail(currentUserName).get(0) instanceof Proprio) {
			session.setAttribute("typeC", "proprio" );
		}
		System.out.println(session.getAttribute("typeC"));
		return "/auth/menu";
		
	}
	
//	@GetMapping("/menu")
//	public ModelAndView menuProprio(HttpSession session) {
//		
//		//passer par userPrincipal dans les jsp. 
//		Compte proprio = new Compte();
//		Optional<Compte> opt = compteRepository.findById(1);
//		if(opt.isPresent()) {
//			proprio= (Compte) opt.get();
//		}
//		session.setAttribute("numC", proprio.getNumC());
//
//		return new ModelAndView("auth/menu", "compte", (Proprio) proprio );
//	}
	
//	@GetMapping("/menu")
//	public ModelAndView menuSitter(HttpSession session) {
//		Compte proprio = new Compte();
//		Optional<Compte> opt = compteRepository.findById(100);
//		if(opt.isPresent()) {
//			proprio= opt.get();
//		}
//		session.setAttribute("numC", proprio.getNumC());
//		return new ModelAndView("menu", "compte", (Sitter) proprio );
//	}
	
	@GetMapping("/accueil")
	public String Accueil() {

		return "accueil";
	}
	
	@GetMapping("/connexion")
	public String Connexion() {
		return "connexion";
	}
	

	
	
}
