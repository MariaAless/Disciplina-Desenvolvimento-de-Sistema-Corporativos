package com.alessandra.sistema_de_biblioteca.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "TB_ITEM_EMPRESTIMO")
public class LoanItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimo_id")
    private LoanModel emprestimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id")
    private BookModel livro;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LoanModel getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(LoanModel emprestimo) {
        this.emprestimo = emprestimo;
    }

    public BookModel getLivro() {
        return livro;
    }
    public void setLivro(BookModel livro) {
        this.livro = livro;
    }
}
