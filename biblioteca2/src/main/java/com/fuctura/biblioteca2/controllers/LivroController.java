package com.fuctura.biblioteca2.controllers;

import com.fuctura.biblioteca2.dtos.LivroDto;
import com.fuctura.biblioteca2.models.Livro;
import com.fuctura.biblioteca2.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
@CrossOrigin("*")
public class LivroController {
    @Autowired
    private LivroService livroService;
    @GetMapping("/{id}")
    @Operation(summary = "Busca de livro por ID")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }
    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam (value = "categoria", defaultValue = "0") Integer id){
        List<Livro> list = livroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }
   @GetMapping ("/categoria/{nome}")
    public ResponseEntity<List<LivroDto>> findAllByNome(@PathVariable String nome){
        List<Livro> list = livroService.findAllLivroByCategoria(nome);
       return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LivroDto> save (@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
                                          @RequestBody LivroDto livroDto){
        Livro livro = livroService.save(id_cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> upDate (@PathVariable Integer id, @RequestBody LivroDto livroDto){
        Livro livro = livroService.upDate(id, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}