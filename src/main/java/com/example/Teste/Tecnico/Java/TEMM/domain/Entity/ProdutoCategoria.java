package com.example.Teste.Tecnico.Java.TEMM.domain.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Embeddable
public class ProdutoCategoria implements  Serializable {


    @ManyToOne
    @JoinColumn(name = "id")
    private Produto produto;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id")
    private Categoria categoria;
    


}
