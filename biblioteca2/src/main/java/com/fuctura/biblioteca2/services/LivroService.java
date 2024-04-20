package com.fuctura.biblioteca2.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.biblioteca2.dtos.CategoriaDto;
import com.fuctura.biblioteca2.dtos.LivroDto;
import com.fuctura.biblioteca2.enuns.Tamanho;
import com.fuctura.biblioteca2.exceptions.ObjectNotFoundException;
import com.fuctura.biblioteca2.models.Categoria;
import com.fuctura.biblioteca2.models.Livro;
import com.fuctura.biblioteca2.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> livro =  livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado."));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoria(id_cat);
    }

    public List<Livro> findAllLivroByCategoria(String nome) {
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }

    public Livro save(Integer idCat, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        livroDto.setCategoria(cat);
        return livroRepository.save(new Livro(livroDto));
    }

    public Livro upDate(Integer id, LivroDto livroDto) {
        Livro livro = findById(id);
        livroDto.setId(id);
        upDateDados(livro, livroDto);
        return livroRepository.save(livro);
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    private void upDateDados(Livro livro, LivroDto livroDto){
        livro.setNome(livroDto.getNome());
        livro.setAutor(livroDto.getAutor());
        livro.setTexto(livroDto.getTexto());
        livro.setTamanho(livroDto.getTamanho());
        livro.setCategoria(livroDto.getCategoria());
    }
}