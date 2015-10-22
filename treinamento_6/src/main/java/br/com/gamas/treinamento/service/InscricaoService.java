package br.com.gamas.treinamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamas.treinamento.model.Inscricao;
import br.com.gamas.treinamento.model.Situacao;
import br.com.gamas.treinamento.repository.InscricaoRepository;

@Service
public class InscricaoService {
	
	@Autowired
	private InscricaoRepository inscricaoRepository; 

	public Inscricao buscarInscricaoPorId(Long id) {
		return inscricaoRepository.findOne(id);
	}

	public void save(Inscricao inscricao) {
		inscricaoRepository.save(inscricao);
	}

	public List<Inscricao> findAll() {
		return inscricaoRepository.findAll();
	}

	public void alterarSituacao(Long id, Situacao situacao) {
		Inscricao inscricao = buscarInscricaoPorId(id);
		if (inscricao != null){
			inscricao.setSituacao(situacao);
			inscricaoRepository.save(inscricao);
		}
	}


}