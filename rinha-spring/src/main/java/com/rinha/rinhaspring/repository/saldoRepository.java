package com.rinha.rinhaspring.repository;

import com.rinha.rinhaspring.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface saldoRepository extends JpaRepository<Saldo, Integer>{
}
