package poe.spring.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.form.TrajetForm;
import poe.spring.service.TrajetManagerService;

@Controller
@RequestMapping("/creation_trajet")
public class CreationTrajetController {

	@Autowired
	TrajetManagerService trajetManagerService;
	
	@GetMapping
	public String creationTrajet(TrajetForm form) {
		return "creation_trajet"; //retour = nom du html
	}
	
	@PostMapping
	//username et password sont present dans sign_in.html (même nom)
	public String saveTrajet(@Valid TrajetForm form, BindingResult bindingResult, RedirectAttributes attr) {
		System.out.println("ville depart : "+ form.getVilleDepart() +", pwd : " + form.getVilleArrivee());
		
		if(bindingResult.hasErrors()) {
			return "creation_trajet";
		}
		attr.addAttribute("message", "Creation of a trip");
//		attr.addAttribute("password", form.getPassword());
		trajetManagerService.save(form.getVilleDepart(), form.getVilleArrivee(), form.getDateDepart(), form.getPrix(), form.getNombreDePlace());
		return "redirect:/creation_trajet/success";
	}
	
	@GetMapping("/success")
	public String succes(String message, Model model) {
		model.addAttribute("message", message);
		return "success";
	}
}
