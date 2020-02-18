package petSitting.frontBoot.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import petSitting.frontBoot.model.Compte;
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
	public String accueil() {

		return "accueil";
	}
	
	@GetMapping("/connexion")
	public String connexion() {
		return "connexion";
	}
	
	@GetMapping("/deconnexion")
	public String deconnexion() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "accueil";
	}
	
	@GetMapping("/inscription")
	public String formulaireIns(Model model) {
		model.addAttribute("compte", new Compte());
		model.addAttribute("type","");
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String inscription(@ModelAttribute("compte") Compte compte, @RequestParam(name="type") String type) {
		
		return "connexion";
	}
	
	
}
