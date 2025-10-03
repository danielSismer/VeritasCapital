package com.veritasCapital.bank.repository;

import com.veritasCapital.bank.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
