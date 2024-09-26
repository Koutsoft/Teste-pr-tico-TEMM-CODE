package com.example.Teste.Tecnico.Java.TEMM.domain.Controller;

import org.hibernate.mapping.List;
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

import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Categoria;
import com.example.Teste.Tecnico.Java.TEMM.domain.Entity.Produto;
import com.example.Teste.Tecnico.Java.TEMM.domain.service.CategoriaService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/categoria")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

      @PostMapping("/cadastrarCategoria")
    public ResponseEntity<Categoria> cadastrarProduto(@RequestBody Categoria cat) {
        Categoria categoria =   categoriaService.addNovCategoria(cat);
    return  new ResponseEntity<>(categoria, HttpStatus.CREATED);

    }


     @DeleteMapping("{idCategoria}")
    public Categoria deletaCategoria(@PathVariable("idCategoria") Long idCategoria){

    return categoriaService.deleletarCategoria(idCategoria);

    }

     @PutMapping("/atualizarCategoria/{idCategoria}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable("idCategoria")Long id,@RequestBody Categoria cat) {
        
        Categoria categoria = categoriaService.updateCategoria(id, cat);
        return new ResponseEntity<>(categoria,HttpStatus.OK);
    }


   

 
    

}
