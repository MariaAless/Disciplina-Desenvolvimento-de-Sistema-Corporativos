package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
