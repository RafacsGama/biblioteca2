package com.fuctura.biblioteca2.services;

import com.fuctura.biblioteca2.dtos.CategoriaDto;
import com.fuctura.biblioteca2.exceptions.DataIntegrityViolationException;
import com.fuctura.biblioteca2.exceptions.IllegalArgumentsExceptions;
import com.fuctura.biblioteca2.exceptions.ObjectNotFoundException;
import com.fuctura.biblioteca2.models.Categoria;
import com.fuctura.biblioteca2.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;
    public Categoria findById(Integer id){
        Optional<Categoria> cat =  categoriaRepository.findById(id);
        if(cat.isPresent()){
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada.");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDto categoriaDto) {
        findByNome(categoriaDto);
        categoriaDto.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    public Categoria upDate(CategoriaDto categoriaDto) {
        findById(categoriaDto.getId());
        findByNome(categoriaDto);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if(!cat.get().getLivros().isEmpty()){
            throw new DataIntegrityViolationException("Categoria possui livros, não pode ser deletada.");
        }
        categoriaRepository.deleteById(id);
    }


    private void findByNome(CategoriaDto categoriaDto){
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDto.getNome());
        if(cat.isPresent() && cat.get().getNome().equals(categoriaDto.getNome())){
            throw new IllegalArgumentsExceptions("Já existe uma categoria com este nome. "+ categoriaDto.getNome());
        }
    }

    public void buscarPorNome(String nome){
        Optional<Categoria> cat = categoriaRepository.findByNomeContainingIgnoreCase(nome);
        if (cat.isEmpty()){
            throw new ObjectNotFoundException("Categoria não encontrada!");
        }
    }


}