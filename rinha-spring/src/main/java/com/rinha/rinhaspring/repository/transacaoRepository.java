package com.rinha.rinhaspring.repository;

import com.rinha.rinhaspring.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transacaoRepository extends JpaRepository<Transacao, Integer> {
}
