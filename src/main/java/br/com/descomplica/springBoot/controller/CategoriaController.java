package br.com.descomplica.springBoot.controller;

import br.com.descomplica.springBoot.entity.Categoria;
import br.com.descomplica.springBoot.entity.Produto;
import br.com.descomplica.springBoot.openapi.CategoriaControllerOpenApi;
import br.com.descomplica.springBoot.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements CategoriaControllerOpenApi {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> getAll() {
        return categoriaService.getAll();
    }

    @GetMapping(value = "/{id}/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> getAllByCategoryId(@PathVariable String id) {
        return categoriaService.getAllProductsByCategoriaId(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria getById(@PathVariable String id) {
        return categoriaService.getById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria create(@RequestBody @Valid Categoria categoria) {
        return categoriaService.create(categoria);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria updateCategoria(@PathVariable String id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCategoria(String id) {
        categoriaService.deleteCategoria(id);
    }


}
