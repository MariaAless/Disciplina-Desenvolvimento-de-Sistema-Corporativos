package com.alessandra.sistema_de_biblioteca.repositories;

import com.alessandra.sistema_de_biblioteca.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
}
