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

import poe.spring.form.LoginForm;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/sign_in")
public class SignInController {

	@Autowired
	UserManagerService userManagerService;
	
	@GetMapping
	public String signIn(LoginForm form) {
		return "sign_in"; //retour = nom du html
	}
	
//	@PostMapping
//	//username et password sont present dans sign_in.html (même nom)
//	public String signInUser(String username, String password, RedirectAttributes attr) {
//		System.out.println("username : "+username+", pwd : " + password);
//		attr.addAttribute("username", username);
//		attr.addAttribute("username", password);
//		userManagerService.signup(username, password);
//		return "redirect:/sign_in/success";
//	}
	
	@PostMapping
	//username et password sont present dans sign_in.html (même nom)
	public String signInUser(@Valid LoginForm form, BindingResult bindingResult, RedirectAttributes attr) {
		System.out.println("login : "+ form.getLogin() +", pwd : " + form.getPassword());
		
		if(bindingResult.hasErrors()) {
			return "sign_in";
		}
		attr.addAttribute("username", form.getLogin());
		attr.addAttribute("password", form.getPassword());
		attr.addAttribute("message", "Sign in");
		userManagerService.signup(form.getLogin(), form.getPassword());
		return "redirect:/creation_trajet";
	}
	
	
	@GetMapping("/success")
	public String succes(String username, String password,String message, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("message", message);
		return "success";
	}
	
}
