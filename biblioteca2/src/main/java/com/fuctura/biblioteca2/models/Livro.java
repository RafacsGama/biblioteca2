package com.fuctura.biblioteca2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.biblioteca2.dtos.LivroDto;
import com.fuctura.biblioteca2.enuns.Tamanho;

import javax.persistence.*;

@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String autor;
    private String texto;

    private Tamanho tamanho;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro(Integer id, String nome, String autor, String texto, Categoria categoria, Tamanho tamanho) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
        this.tamanho = tamanho;
    }

    public Livro() {
    }

    public Livro(LivroDto livroDto) {
        this.id = livroDto.getId();
        this.nome = livroDto.getNome();
        this.autor = livroDto.getAutor();
        this.texto = livroDto.getTexto();
        this.categoria = livroDto.getCategoria();
        this.tamanho = livroDto.getTamanho();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
}
