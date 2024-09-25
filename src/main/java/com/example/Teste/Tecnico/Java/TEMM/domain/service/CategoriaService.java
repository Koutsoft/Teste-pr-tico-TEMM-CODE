package com.example.Teste.Tecnico.Java.TEMM.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.CategoriaRepositoy;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepositoy categoriaRepositoy;




   public List<Categoria> listarProdutos (){
     return   this.categoriaRepositoy.findAll();
        
    }

    public Categoria addNovCategoria(Categoria cat){
        return this.categoriaRepositoy.save(cat);
    }


    public Categoria updateCategoria(Categoria cat){
        @SuppressWarnings("deprecation")
        Categoria categoriaUpdate = this.categoriaRepositoy.getOne(cat.getId());
        categoriaUpdate.setDescriacao(cat.getDescriacao());
        categoriaUpdate.setNome(cat.getNome());
        return this.categoriaRepositoy.save(categoriaUpdate);
    }


}
