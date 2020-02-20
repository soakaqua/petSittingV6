package petSitting.frontBoot.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import petSitting.frontBoot.model.Annonce;
import petSitting.frontBoot.model.Annonce_Service;
import petSitting.frontBoot.model.Annonce_ServicePK;
import petSitting.frontBoot.model.Compte;
import petSitting.frontBoot.model.Proprio;
import petSitting.frontBoot.model.Reponse;
import petSitting.frontBoot.model.Service;
import petSitting.frontBoot.repositories.AnnonceRepository;
import petSitting.frontBoot.repositories.Annonce_ServiceRepository;
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
	Annonce_ServiceRepository annonce_serviceRepository;
	
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
		model.addAttribute("annonces", annonceRepository.selectAnnonceByProprioWhereStatut0(numC));
		return "auth/proprio/consulterAnnonces";
	}
	
	
	@GetMapping("/consulterAnnoncesTerminees")
	public String consulterAnnoncesTerminees(Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		model.addAttribute("numC", numC);
		model.addAttribute("annoncesT", annonceRepository.afficherAnnoncesTerminees(numC));
		return "auth/proprio/consulterAnnoncesTerminees";
	}
	

	@PostMapping("noterAnnonce")
	public String noterAnnonce (@RequestParam(name="numA") Integer numA,@RequestParam(name="noteS") Integer noteS, Model model) {
		Annonce a = new Annonce();
		Optional<Annonce> annonceTrouv = annonceRepository.findById(numA);
		if(annonceTrouv.isPresent()) {
			a= annonceTrouv.get();
		}
		a.setNoteS((double) noteS);
		annonceRepository.save(a);
		
		return ("redirect:/proprio/consulterAnnonces");
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
		return "auth/proprio/modifierAnnonce";
		
	}

	@PostMapping("/save")
	private String save(@ModelAttribute("annonce") @Valid Annonce annonce, @RequestParam Integer[] checkboxServices, BindingResult br, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		Integer numA = annonce.getNumA();
		annonce_serviceRepository.supprAnnonceServiceByNumA(numA);
		if (br.hasErrors()) {
			return "auth/proprio/modifierAnnonce";
		} else {
			Optional<Compte> opt = compteRepository.findById(numC);
			Compte p = new Proprio();
			if (opt.isPresent()) {
				p = opt.get();
				annonce.setStatut(0);						

				Annonce annonceFinale = annonceService.save(annonce, (Proprio) p);
				
				//Créer une LISTE ORDONNEE qui récupère les services sélectionnés
				List<Service> listServices = new ArrayList();
				for(int i=0; i<checkboxServices.length; i++) {
					Optional<Service> opt2 = serviceRepository.findById(checkboxServices[i]);
					Service serviceRecup = null;
					if (opt2.isPresent()) {
						serviceRecup = opt2.get();
						listServices.add(serviceRecup);
					}					
				}
				
				//Convertir la liste de services en Set Annonce_Service				
				Set<Annonce_Service> setAnnonceService = new HashSet<Annonce_Service>();
				Annonce_Service annServ = new Annonce_Service();
				Annonce_ServicePK annServPK = new Annonce_ServicePK();
				for(int j=0; j<listServices.size();j++) {
				System.out.println("annonce : "+annonceFinale.getNumA());
					annServPK.setAnnonce(annonceFinale);
					annServPK.setService(listServices.get(j)); 
					annServ.setKey(annServPK);
					System.out.println("annServ i: "+annServ);
					setAnnonceService.add(annServ);
					annonce_serviceRepository.save(annServ);
				}
				//Enregistrer le nouveau Set Annonce_Service
				annonceFinale.setAnnonce_service(setAnnonceService);
				annonceService.save(annonceFinale, (Proprio) p);
			}
			return "redirect:/proprio/consulterAnnonces";
		}	
	}

	@GetMapping("/afficherReponses")
	public String afficherReponses(@RequestParam(name = "numA") Integer numA, Model model, HttpSession session) {
		Integer numC = (Integer) session.getAttribute("numC");
		model.addAttribute("numC", numC);
		model.addAttribute("reponses", reponseRepository.selectReponseByNumA(numA));
		
		List<Reponse> lstR = new ArrayList<Reponse>();
		lstR = reponseRepository.selectReponseByNumA(numA);
		List<String> lstM = new ArrayList<String>();
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.CEILING);
		
		for(int i =0 ; i< lstR.size(); i++) {
			if(Double.isNaN(annonceService.moyenneSitter(lstR.get(i).getKey().getSitter().getNumC())) != true) {
				lstM.add(df.format(annonceService.moyenneSitter(lstR.get(i).getKey().getSitter().getNumC()))) ;
			}
			else {
				lstM.add("null");
			}
		}
		model.addAttribute("moyenneS", lstM);
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
		annonce_serviceRepository.supprAnnonceServiceByNumA(numA);
		annonceRepository.deleteByNumA(numA);
		return new ModelAndView("redirect:/proprio/consulterAnnonces", "numC", numC);
	}

}