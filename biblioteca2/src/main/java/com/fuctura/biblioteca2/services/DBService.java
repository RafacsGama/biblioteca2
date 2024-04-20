package com.fuctura.biblioteca2.services;

import com.fuctura.biblioteca2.enuns.Tamanho;
import com.fuctura.biblioteca2.models.Categoria;
import com.fuctura.biblioteca2.models.Livro;
import com.fuctura.biblioteca2.repositories.CategoriaRepository;
import com.fuctura.biblioteca2.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    public void instanciaDB(){
        Categoria cat1 = new Categoria(null,"Informática","Livros de Informática");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", cat1, Tamanho.MEDIO);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1, Tamanho.GRANDE);
        Livro l3 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", cat2, Tamanho.MEDIO);
        Livro l4 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", cat2, Tamanho.PEQUENO);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", cat2, Tamanho.GRANDE);

        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

        //salvar
        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
    }
}