package com.example.Teste.Tecnico.Java.TEMM;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Teste.Tecnico.Java.TEMM.domain.Controller.CategoriaController;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;

@ExtendWith(MockitoExtension.class)
public class CategoriaControllerTest {

    //TODO veriicar o pq está danddo nullPointer;
    @InjectMocks
    CategoriaController controller;



    // @Test
    // public void cadastrarProduto(){
    //     controller.cadastrarProduto(this.categoria());
    // }

    @Test
    public void deletaCategoria(){
        controller.deletaCategoria(1L);
    }

    // @Test
    // public void updateCategoria(){
    //     controller.updateCategoria(1L,this.categoria());
    // }

    @Test
    public void listarTodasCategorias(){
        controller.listarTodasCategorias();
    }


    private Categoria categoria(){
        Categoria cat = new Categoria();
        cat.setDescricao("eletronicos");
        cat.setId(1L);
        cat.setNome("Eletronicos");
        Produto prod = new Produto();
        // List<Produto> produtolist = new ArrayList<>();
        // produtolist.add(prod);
      //  cat.setProdutos(new ArrayList<>());
        return cat;
    }

}
