package com.fuctura.biblioteca2.repositories;

import com.fuctura.biblioteca2.models.Categoria;
import com.fuctura.biblioteca2.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.id =:id_cat")
    List<Livro> findAllLivrosByCategoria(@Param(value = "id_cat") Integer id_cat);

    List<Livro> findByCategoriaNomeContainingIgnoreCase(String nome);
}