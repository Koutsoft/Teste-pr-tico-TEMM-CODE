package com.example.Teste.Tecnico.Java.TEMM.domain.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.ProdutoService;







@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping("/listarProdutos")
    public ResponseEntity<List<Produto>> listarProdutos() throws Exception {
        List<Produto> produto = produtoService.listarTodosOsProdutos();
    return new ResponseEntity<>(produto, HttpStatus.OK);

    }

    @PostMapping("/cadastrarProduto")
    public ResponseEntity<  Produto> cadastrarProduto(@RequestBody Produto prod) {
      Produto produto =   produtoService.salvarNovoProduto(prod);
    return  new ResponseEntity<>(produto, HttpStatus.CREATED);

    }

    @DeleteMapping("{idProduto}")
    public Produto deletarProduto(@PathVariable("idProduto") Long idProduto){

    return produtoService.deletarProduto(idProduto);

    }

    @PutMapping("/atualizarProduto/{idProduto}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("idProduto")Long id,@RequestBody Produto prod) {
        
        Produto produto = produtoService.updateProduto(id,prod);
        return new ResponseEntity<>(produto,HttpStatus.OK);
    }

    @GetMapping("/listar/{categoriaID}")
    public ResponseEntity<List<Produto>> listarTodosOsProdutosPorCategoria(@PathVariable Long categoriaID){
      List<Produto> produto =  produtoService.listProdPorCat(categoriaID);
        return new ResponseEntity<>(produto,HttpStatus.OK);
    }
    

   
    






}
