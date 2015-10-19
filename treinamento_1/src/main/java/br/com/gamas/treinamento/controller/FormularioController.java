package br.com.gamas.treinamento.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gamas.treinamento.model.Inscricao;
import br.com.gamas.treinamento.model.InscricaoData;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

	@RequestMapping(value = "/inscricao", method = RequestMethod.GET)
	public String root(@ModelAttribute Inscricao inscricao) {
		return "pages/formulario";
	}

	@RequestMapping(value = "/visualizar/{id}", method = RequestMethod.GET)
	public ModelAndView view(@PathVariable("id") Long id) {
		Inscricao inscricao = InscricaoData.buscarInscricaoPorId(id);
		return new ModelAndView("pages/visualizar").addObject("inscricao", inscricao);
	}

	@RequestMapping(value = "/salvar", method = { RequestMethod.POST })
	public ModelAndView salvar(@Valid Inscricao inscricao, BindingResult result, RedirectAttributes redirect) {
		List<String> erros = new ArrayList<>();

		if (result.hasErrors()) {
			for (FieldError erro: result.getFieldErrors()) {
				erros.add(erro.getObjectName() + "." + erro.getField() + ": " + erro.getDefaultMessage());
			}
			
			return new ModelAndView("pages/formulario", "formErrors", erros);
		}

		inscricao.setId(System.currentTimeMillis());
		inscricao.setDataInscricao(new Date());
		InscricaoData.inscricoes.add(inscricao);

		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");

		return new ModelAndView("redirect:/formulario/visualizar/{inscricao.id}", "inscricao.id", inscricao.getId());

	}

}
