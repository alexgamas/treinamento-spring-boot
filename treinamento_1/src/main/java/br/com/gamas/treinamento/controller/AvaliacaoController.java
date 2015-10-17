package br.com.gamas.treinamento.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.gamas.treinamento.model.Inscricao;
import br.com.gamas.treinamento.model.InscricaoData;
import br.com.gamas.treinamento.model.Situacao;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView view() {
		List<Inscricao> inscricoes = InscricaoData.inscricoes;
		return new ModelAndView("pages/lista").addObject("inscricoes", inscricoes);
	}
	
	@RequestMapping(value = "/aprovar/{id}", method = RequestMethod.GET)
	public ModelAndView aprovar(@PathVariable("id") Long id) {
		alterarSituacao(id, Situacao.APROVADO);
		return new ModelAndView("redirect:/avaliacao/lista");
	}
	
	@RequestMapping(value = "/reprovar/{id}", method = RequestMethod.GET)
	public ModelAndView reprovar(@PathVariable("id") Long id) {
		alterarSituacao(id, Situacao.REPROVADO);
		return new ModelAndView("redirect:/avaliacao/lista");
	}
	
	private void alterarSituacao(Long id, Situacao situacao){
		Inscricao inscricao = InscricaoData.buscarInscricaoPorId(id);
		if (inscricao != null) {
			inscricao.setSituacao(situacao);
		}
	}
	
	

}
