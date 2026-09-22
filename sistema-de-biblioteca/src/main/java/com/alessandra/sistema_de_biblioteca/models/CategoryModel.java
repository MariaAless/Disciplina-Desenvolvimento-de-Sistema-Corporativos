package com.alessandra.sistema_de_biblioteca.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name= "TB_CATEGORIA")
public class CategoryModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private Set<BookModel> livros = new HashSet<>();



    public Set<BookModel> getLivros() {
        return livros;
    }
    public void setLivros(Set<BookModel> livros) {
        this.livros = livros;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
