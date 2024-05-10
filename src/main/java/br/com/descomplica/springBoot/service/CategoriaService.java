package br.com.descomplica.springBoot.service;

import br.com.descomplica.springBoot.entity.Categoria;
import br.com.descomplica.springBoot.entity.Produto;
import br.com.descomplica.springBoot.repository.CategoriaRepository;
import br.com.descomplica.springBoot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Categoria> getAll() { return categoriaRepository.findAll(); }

    public List<Produto> getAllProductsByCategoriaId(String id) {
        return produtoRepository.getAllProductsByCategoryId(id);
    }

    public Categoria getById(String id) { return categoriaRepository.findById(id).get(); }

    public Categoria create(Categoria dados) {
        Categoria cat = new Categoria();
        cat.setNome(dados.getNome());
        return categoriaRepository.save(cat);
    }

    public Categoria updateCategoria(String id, Categoria dados) {
        Categoria catUpdate = categoriaRepository.findById(id).get();

        if(catUpdate != null)
            catUpdate.setNome(dados.getNome());

        return categoriaRepository.save(catUpdate);
    }

    public void deleteCategoria(String id) {
        categoriaRepository.deleteById(id);
    }


}
