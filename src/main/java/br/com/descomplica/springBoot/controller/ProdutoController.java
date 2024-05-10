package br.com.descomplica.springBoot.controller;

import br.com.descomplica.springBoot.entity.Produto;
import br.com.descomplica.springBoot.openapi.ProdutoControllerOpenApi;
import br.com.descomplica.springBoot.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController implements ProdutoControllerOpenApi {
    @Autowired
    ProdutoService produtoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> getAll() {
        return produtoService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto getById(@PathVariable String id) {
        return produtoService.getById(id);

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto create(@RequestBody @Valid Produto produto) {
          return produtoService.create(produto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto updateProduto(@PathVariable String id, @RequestBody @Valid Produto produto) {
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduto(@PathVariable String id) {
        produtoService.deleteProduto(id);
    }

}
