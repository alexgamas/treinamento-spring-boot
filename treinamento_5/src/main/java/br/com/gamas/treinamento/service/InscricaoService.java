package br.com.gamas.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamas.treinamento.model.Inscricao;
import br.com.gamas.treinamento.model.Situacao;
import br.com.gamas.treinamento.repository.InscricaoRepository;
import br.com.gamas.treinamento.service.mail.MailService;

@Service
public class InscricaoService {
	
	@Autowired
	private InscricaoRepository inscricaoRepository; 

	@Autowired
	private MailService mailService;
	
	public Inscricao buscarInscricaoPorId(Long id) {
		return inscricaoRepository.findOne(id);
	}

	public void save(Inscricao inscricao) {
		inscricaoRepository.save(inscricao);
		mailService.sendMail(inscricao.getEmail(), "Cadastro realizado", "Seu cadastro foi criado com sucesso, aguarde parecer.");
	}

	public List<Inscricao> findAll() {
		return inscricaoRepository.findAll();
	}

	public void alterarSituacao(Long id, Situacao situacao) {
		Inscricao inscricao = buscarInscricaoPorId(id);
		
		if (inscricao != null){

			inscricaoRepository.save(inscricao);
			
			StringBuilder sb = new StringBuilder();
			sb.append("Seu cadastro de número: ");
			sb.append(inscricao.getId());
			sb.append(" foi ");
			sb.append(situacao.getDescricao());
			sb.append(".");
			
			mailService.sendMail(inscricao.getEmail(), "Alteração de cadastro.", sb.toString());
			inscricao.setSituacao(situacao);
		}
	}


}