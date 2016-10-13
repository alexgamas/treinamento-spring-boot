package br.com.gamas.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gamas.treinamento.model.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
