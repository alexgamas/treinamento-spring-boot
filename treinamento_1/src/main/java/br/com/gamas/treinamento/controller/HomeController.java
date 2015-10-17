package br.com.gamas.treinamento.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String root(Map<String, Object> model) {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home() {
		return "pages/home";
	}
}
