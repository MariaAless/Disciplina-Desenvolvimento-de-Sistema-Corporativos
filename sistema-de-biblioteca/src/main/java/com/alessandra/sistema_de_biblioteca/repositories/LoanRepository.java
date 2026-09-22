package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.enums.LoanStatus;
import com.alessandra.sistema_de_biblioteca.models.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LoanRepository extends JpaRepository<LoanModel, UUID> {

    // empréstimos ativos de um usuário, com os livros já carregados
    @Query("SELECT DISTINCT e FROM LoanModel e " +
            "JOIN FETCH e.itens i JOIN FETCH i.livro " +
            "WHERE e.usuario.id = :usuarioId AND e.status = :status")
    List<LoanModel> findActiveLoansByUser(
            @Param("usuarioId") UUID usuarioId,
            @Param("status") LoanStatus status);

    // empréstimos atrasados, com usuário e livros já carregados
    @Query("SELECT DISTINCT e FROM LoanModel e " +
            "JOIN FETCH e.usuario " +
            "JOIN FETCH e.itens i JOIN FETCH i.livro " +
            "WHERE e.dataDevolucaoPrevista < :hoje AND e.status = :status")
    List<LoanModel> findOverdueLoans(
            @Param("hoje") LocalDate hoje,
            @Param("status") LoanStatus status);
}
