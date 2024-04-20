package com.fuctura.biblioteca2.controllers;

import com.fuctura.biblioteca2.dtos.CategoriaDto;
import com.fuctura.biblioteca2.models.Categoria;
import com.fuctura.biblioteca2.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
//    @GetMapping("{id}")=findById(id);
//    @GetMapping=findAll;
//    @PostMapping = save;
//    @PutMapping = atualizar;
//    @DeleteMapping = deletar;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/{id}")
    @Operation(summary = "Busca de categoria por ID")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id){
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
    }
    @PostMapping
    public ResponseEntity<CategoriaDto> save(@Valid @RequestBody CategoriaDto categoriaDto){
        Categoria cat = categoriaService.save(categoriaDto);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> upDate(@Valid @PathVariable Integer id, @RequestBody CategoriaDto categoriaDto){
        categoriaDto.setId(id);
        Categoria cat = categoriaService.upDate(categoriaDto);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}