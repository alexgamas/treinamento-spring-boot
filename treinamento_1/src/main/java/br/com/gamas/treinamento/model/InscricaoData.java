package br.com.gamas.treinamento.model;

import java.util.LinkedList;
import java.util.List;

public class InscricaoData {

	public static List<Inscricao> inscricoes = new LinkedList<>();

	public static Inscricao buscarInscricaoPorId(Long id) {
		if (inscricoes != null && id != null) {
			for (Inscricao inscricao : inscricoes) {
				if (id.equals(inscricao.getId())){
					return inscricao;
				}
			}
		}
		
		return null;
	}
	
}
