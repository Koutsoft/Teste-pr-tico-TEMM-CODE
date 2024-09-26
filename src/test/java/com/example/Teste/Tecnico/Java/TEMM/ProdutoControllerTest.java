package com.example.Teste.Tecnico.Java.TEMM;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Teste.Tecnico.Java.TEMM.domain.Controller.ProdutoController;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.ProdutoService;



@ExtendWith(MockitoExtension.class)

public class ProdutoControllerTest {


    @InjectMocks
    ProdutoController controller;

    @Mock
    ProdutoService service;

    @BeforeEach
    public void setup(){
    }
   

    @Test
    public void cadastrarProduto(){
      controller.cadastrarProduto(this.prod());
      
    }

    @Test
    public void listarProdutosTest()throws Exception{
        controller.listarProdutos();
    }

    @Test
    public void deletarProduto(){
        controller.deletarProduto(1L);
    }

    @Test
    public void updateProduto(){
        controller.updateProduto(1L,this.prod());
    }

    @Test
    public void listarTodosOsProdutosPorCategoria(){
        controller.listarTodosOsProdutosPorCategoria(1L);
    }



    private Produto prod(){
        Produto prod = new Produto();

        prod.setCategoriaID(1L);
        prod.setId(2l);
        prod.setNome("iPhone 11");
        prod.setQuantidadeEmEstoque(20);
        prod.setDescricao("celular de ultima geracao");
        Categoria cat = new Categoria();

        cat.setDescricao("eletronico");
        cat.setId(1L);
        cat.setNome("celulares");

        prod.setCategoria(cat);
        return prod;
    }

    private Categoria categoria(){
        Categoria cat = new Categoria();
        cat.setDescricao("eletronicos");
        cat.setId(1L);
        cat.setNome("Eletronicos");
        Produto prod = new Produto();
        // List<Produto> produtolist = new ArrayList<>();
        // produtolist.add(prod);
        cat.setProdutos(new ArrayList<>());
        return cat;
    }
}
