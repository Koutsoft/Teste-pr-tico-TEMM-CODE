package com.example.Teste.Tecnico.Java.TEMM;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Teste.Tecnico.Java.TEMM.domain.Controller.ProdutoController;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.ProdutoRepository;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.ProdutoService;



@ExtendWith(MockitoExtension.class)

public class ProdutoControllerTest {

    @Mock 
    private ProdutoRepository produtoRepository;
    private ProdutoService service;
    @InjectMocks
    ProdutoController controller;
   

    @Test
    public void cadastrarProduto(){
         Mockito.when(service.salvarNovoProduto(this.ProdutoTest())).thenReturn(new Produto());
        
    }


    private Produto ProdutoTest(){
        Produto prod = new Produto();
       // prod.setCategoria("brinquedo");
        prod.setNome("buzz");
        prod.setId(1L);
        prod.setPreco(new BigDecimal(10.0));
        prod.setQuantidadeEmEstoque(1);
        prod.setDescricao("disney");

        return prod;

    }
}
