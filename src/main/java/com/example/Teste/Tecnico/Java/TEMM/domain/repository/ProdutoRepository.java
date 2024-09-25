package com.example.Teste.Tecnico.Java.TEMM.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;


public interface ProdutoRepository extends  JpaRepository<Produto,Long> {

}
