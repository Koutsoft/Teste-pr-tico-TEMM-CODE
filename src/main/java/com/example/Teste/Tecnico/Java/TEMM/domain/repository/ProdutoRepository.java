package com.example.Teste.Tecnico.Java.TEMM.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;



public interface ProdutoRepository extends  JpaRepository<Produto,Long> {

    List<Produto> findByCategoria(Categoria categoria);
}
