package poe.spring.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomepageController{

	@GetMapping
	public String index(Model model) {
		model.addAttribute("message","Welcome beau gosse");
		return "index";
	}

}
