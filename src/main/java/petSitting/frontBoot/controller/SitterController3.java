package petSitting.frontBoot.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
public class SitterController3 {
	
	

	@GetMapping("sitter/ficheSitter") //  a changer a prés par post pour que je puisse voir l erreur par get/ce qu'on ecrit sur le navigateur , c'est l'url appelé sur le front
	public String afficherProfilSitter(Model model) {
		
		return "/auth/sitter/ficheSitter";// le nom de la jsp
	}

	
	



}