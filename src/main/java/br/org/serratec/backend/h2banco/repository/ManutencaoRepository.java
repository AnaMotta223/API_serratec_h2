package br.org.serratec.backend.h2banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.backend.h2banco.domain.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}
