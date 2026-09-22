package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.models.LoanItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanItemRepository extends JpaRepository<LoanItem, UUID> {
}
