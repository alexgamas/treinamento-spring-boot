package br.com.gamas.treinamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String root() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home() {
		return "pages/home";
	}
}
