package petSitting.frontBoot.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.model.Sitter;
import petSitting.frontBoot.repositories.CompteRepository;


@Controller
public class MenuController {
	
	@Autowired
	CompteRepository compteRepository;
	
	

	
	@GetMapping("/auth/menu")
	public String menu(Principal principal, HttpSession session) {
		
		String currentUserName = principal.getName();
		System.out.println(principal.getName());
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
	

	
	@GetMapping("/accueil")
	public String Accueil() {

		return "accueil";
	}
	
	@GetMapping("/connexion")
	public String Connexion() {
		return "connexion";
	}
	

	
	
}
