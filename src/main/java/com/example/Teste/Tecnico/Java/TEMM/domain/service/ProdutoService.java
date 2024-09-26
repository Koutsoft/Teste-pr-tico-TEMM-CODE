package com.example.Teste.Tecnico.Java.TEMM.domain.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.CategoriaRepositoy;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepositoy categoriaRepositoy;

    @Autowired
    private CategoriaService categoriaService;




    public List<Produto> listarTodosOsProdutos() throws Exception {
        List<Produto> produto = produtoRepository.findAll();
         if (produto.isEmpty()) {
            throw new RuntimeException("Procedimento informado não foi encontrado na base de dados");

        }
        return produto;
    }

    public Produto deletarProduto(Long id) {
        Optional<Produto> deletarProduto = this.produtoRepository.findById(id);
        if (deletarProduto.isPresent()) {
            Produto produto = deletarProduto.get();
            produtoRepository.deleteById(id);
            return produto;
        }
        return null;

    }

    public Produto salvarNovoProduto(Produto produto) {
        @SuppressWarnings("deprecation")
		Categoria categoria = this.categoriaRepositoy.getById(produto.getCategoriaID());
      produto.setCategoria(categoria);
      categoria.getProdutos().add(produto);
      this.categoriaRepositoy.save(categoria);
        return this.produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto prod) {

        Produto produtoUpdate = this.produtoRepository.getReferenceById(id);
        produtoUpdate.setDescricao(prod.getDescricao());
        produtoUpdate.setNome(prod.getNome());
        produtoUpdate.setCategoria(prod.getCategoria());
        produtoUpdate.setPreco(prod.getPreco());
        produtoUpdate.setQuantidadeEmEstoque(prod.getQuantidadeEmEstoque());

        return this.produtoRepository.save(produtoUpdate);
    }

    public List<Produto> listProdPorCat(Long id){
        return this.categoriaService.listarProdutosPorCategoria(id);
    }



}
