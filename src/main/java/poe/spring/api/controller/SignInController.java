package poe.spring.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poe.spring.exception.DuplicateLoginBusinessException;
import poe.spring.form.LoginForm;
import poe.spring.service.UserManagerService;

@Controller
@RequestMapping("/sign_in")
public class SignInController {

	private static final Logger LOG = LoggerFactory.getLogger(SignInController.class);
	
	@Autowired
	UserManagerService userManagerService;
	
	@GetMapping
	public String signIn(LoginForm form) {
		return "sign_in"; //retour = nom du html
	}
		
	@PostMapping
	//username et password sont present dans sign_in.html (même nom)
	public String signInUser(@Valid LoginForm form, BindingResult bindingResult,
			   RedirectAttributes attr, Model model) {
		LOG.info("ajout d'un utilisateur login: {0}", form.getLogin());

		if (bindingResult.hasErrors()) {
			return "sign_in";
		}


		try {
			userManagerService.signup(form.getLogin(), form.getPassword());
		} catch (DuplicateLoginBusinessException e) {
			model.addAttribute("error", "Ce login est déjà utilisé!");
			return "sign_in";
		}
		attr.addAttribute("userName", form.getLogin());
		return "redirect:/sign_in/success";
	}
	
	
	@GetMapping("/success")
	public String succes(String username, String password,String message, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("message", message);
		return "success";
	}
	
}
