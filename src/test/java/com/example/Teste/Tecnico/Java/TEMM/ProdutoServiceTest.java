package com.example.Teste.Tecnico.Java.TEMM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.CategoriaRepositoy;
import com.example.Teste.Tecnico.Java.TEMM.domain.repository.ProdutoRepository;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.CategoriaService;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.ProdutoService;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @InjectMocks
    ProdutoService service;


    @Mock
    ProdutoRepository produtoRepository;

    @Mock
    CategoriaRepositoy categoriaRepositoy;

    @Mock
    CategoriaService catService;

    @BeforeEach
    public void setup(){
    }

    @Test
    public void listProdPorCatTest(){
        Mockito.when(catService.listarProdutosPorCategoria(1l)).thenReturn(Collections.singletonList(this.prod()));
     List<Produto> produto =   service.listProdPorCat(1L);
        assertEquals(Collections.singletonList(this.prod()),produto);
        assertNotNull(produto);
    }

    @Test
    public void listarTodosOsProdutosTest() throws Exception{
        Mockito.when(produtoRepository.findAll()).thenReturn(Collections.singletonList(this.prod()));
        List<Produto> produto = service.listarTodosOsProdutos();
        assertEquals(Collections.singletonList(this.prod()),produto);
        assertNotNull(produto);
    }

    @Test
    public void listarTodosOsProdutosisEmptyTest() throws Exception{
        Mockito.when(produtoRepository.findAll()).thenReturn(Collections.emptyList());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.listarTodosOsProdutos();
        });

        assertEquals("Procedimento informado não foi encontrado na base de dados", exception.getMessage());
    }

   
    @Test 
    public void updateProdutoTest(){
        Mockito.when(produtoRepository.getReferenceById(Mockito.anyLong())).thenReturn(this.prod());
        Produto prod = service.updateProduto(1L, this.prod());
        assertNull(prod);
    }

    @Test
    public void deletarProduto(){
        Mockito.when(produtoRepository.findById(Mockito.any())).thenReturn(Optional.of(new Produto()));
        Produto prod = service.deletarProduto(1L);
        assertNotNull(prod);

    
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
