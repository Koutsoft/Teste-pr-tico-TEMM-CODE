package com.example.Teste.Tecnico.Java.TEMM.domain.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    // @OneToMany
    // @JoinColumn(name="PRODUTO_ID")
    // private List<Produto> produto;

    @OneToMany(mappedBy = "categoria", cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Produto> produtos; 

}
