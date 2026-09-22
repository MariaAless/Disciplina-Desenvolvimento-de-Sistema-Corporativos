package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    // busca parcial por nome, ignorando maiúsculas/minúsculas
    List<UserModel> findByNomeContainingIgnoreCase(String nome);
}
