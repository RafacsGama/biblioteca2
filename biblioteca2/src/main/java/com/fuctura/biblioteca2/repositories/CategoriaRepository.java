package com.fuctura.biblioteca2.repositories;

import com.fuctura.biblioteca2.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Categoria> findByNome(String nome);
    Optional<Categoria> findByNomeContainingIgnoreCase(String nome);
}
