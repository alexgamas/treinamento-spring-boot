package br.com.gamas.treinamento.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {

		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("error", e.getClass().getSimpleName());
		mav.addObject("status", "000");
		mav.addObject("message", e.getMessage());
		
		
		
		return mav;
	}
}