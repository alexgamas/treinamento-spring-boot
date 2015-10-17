package br.com.gamas.treinamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gamas.treinamento.model.Inscricao;
import br.com.gamas.treinamento.service.InscricaoService;

@Controller
@RequestMapping("/formulario")
public class FormularioController {
	
	@Autowired
	private InscricaoService inscricaoService;

	@RequestMapping(value = "/inscricao", method = RequestMethod.GET)
	public String root(@ModelAttribute Inscricao inscricao) {
		return "pages/formulario";
	}

	@RequestMapping(value = "/visualizar/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable("id") Long id) {
		Inscricao inscricao = inscricaoService.buscarInscricaoPorId(id);
		return new ModelAndView("pages/visualizar").addObject("inscricao", inscricao);
	}

	@RequestMapping(value = "/salvar", method = { RequestMethod.POST })
	public ModelAndView salvar(@Valid Inscricao inscricao, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return new ModelAndView("pages/formulario", "formErrors", result.getAllErrors());
		}

		inscricaoService.save(inscricao);

		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");

		return new ModelAndView("redirect:/formulario/visualizar/{inscricao.id}", "inscricao.id", inscricao.getId());

	}

}
