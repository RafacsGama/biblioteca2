package com.fuctura.biblioteca2.dtos;

import com.fuctura.biblioteca2.models.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {
    private Integer id;
    @NotEmpty(message = "O campo NOME deve ser preenchido")
    @Length(min = 5, max = 50, message = "O campo NOME deve conter entre 5 e 50 caracteres.")
    private String nome;
    @NotEmpty(message = "O campo DESCRIÇÃO deve ser preenchido")
    @Length(min = 10, max = 200, message = "O campo DESCRIÇÃO deve conter entre 50 e 200 caracteres.")
    private String descricao;
//    private List<Livro> livros = new ArrayList<>();

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaDto() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public List<Livro> getLivros() {
//        return livros;
//    }
//
//    public void setLivros(List<Livro> livros) {
//        this.livros = livros;
}
