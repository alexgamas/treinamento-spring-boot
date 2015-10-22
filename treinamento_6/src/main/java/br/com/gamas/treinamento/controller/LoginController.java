package br.com.gamas.treinamento.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String error) {
        LOGGER.debug("Getting login page, error={}", error);
        return new ModelAndView("pages/login", "error", error);
    }
}
