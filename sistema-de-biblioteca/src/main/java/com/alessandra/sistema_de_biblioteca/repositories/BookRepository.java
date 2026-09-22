package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.dtos.CategoryCountDto;
import com.alessandra.sistema_de_biblioteca.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

    //  livros disponíveis, ordenados por título
    List<BookModel> findByQuantidadeDisponivelGreaterThanOrderByTitulo(Integer quantidade);

    // livros por nome da categoria
    List<BookModel> findByCategoriaNome(String nomeCategoria);

    // livros de um autor, ordenados por ano de publicação
    @Query("SELECT b FROM BookModel b JOIN b.autores a WHERE a.nome = :nomeAutor ORDER BY b.anoPublicacao")
    List<BookModel> findByAutorNomeOrderByAnoPublicacao(@Param("nomeAutor") String nomeAutor);

    // quantidade de livros por categoria, decrescente
    @Query("SELECT c.nome AS nomeCategoria, COUNT(b) AS quantidade " +
            "FROM BookModel b JOIN b.categoria c " +
            "GROUP BY c.nome ORDER BY COUNT(b) DESC")
    List<CategoryCountDto> countBooksByCategory();

}
