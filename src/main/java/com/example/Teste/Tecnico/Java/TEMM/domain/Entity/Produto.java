package com.example.Teste.Tecnico.Java.TEMM.domain.Entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Produto")
@Table(name = "Produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEmEstoque;
    private Long categoriaID;

    // @ManyToOne
    // @JoinColumn(name="CATEGORIA_ID")
    // private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id") // A coluna que referencia a categoria
    @JsonIgnore
    private Categoria categoria;
}
