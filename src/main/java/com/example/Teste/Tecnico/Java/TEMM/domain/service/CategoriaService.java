package com.example.Teste.Tecnico.Java.TEMM.domain.service;

import java.util.List;

import com.example.Teste.Tecnico.Java.TEMM.domain.repository.ProdutoRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.CategoriaRepositoy;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Categoria> listarTodasCategorias() {
        return this.categoriaRepositoy.findAll();

    }

    public Categoria deleletarCategoria(Long id) {
        Optional<Categoria> deletarCat = this.categoriaRepositoy.findById(id);

        if (deletarCat.isPresent()) {
            Categoria categoria = deletarCat.get();
            categoriaRepositoy.deleteById(id);
            return categoria;

        }
        return null;
    }

    public Categoria addNovCategoria(Categoria cat) {
        return this.categoriaRepositoy.save(cat);
    }

    public Categoria updateCategoria(Long id,Categoria cat) {
        @SuppressWarnings("deprecation")
        Categoria categoriaUpdate = this.categoriaRepositoy.getOne(id);
        categoriaUpdate.setDescricao(cat.getDescricao());
        categoriaUpdate.setNome(cat.getNome());
        return this.categoriaRepositoy.save(categoriaUpdate);
    }


    public List<Produto> listarProdutosPorCategoria(Long categoriaID){

        Categoria categoria = new Categoria();
        categoria.setId(categoriaID);
        List<Produto> produtos = this.produtoRepository.findByCategoria(categoria);
        return produtos;
    }
 

}
