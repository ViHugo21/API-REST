package br.com.descomplica.springBoot.service;

import br.com.descomplica.springBoot.entity.Produto;
import br.com.descomplica.springBoot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Produto getById(String id) {
        return produtoRepository.findById(id).get();
    }

    public Produto create(Produto dados) {
        Produto prod = new Produto();

        prod.setCodigoBarras(dados.getCodigoBarras());
        prod.setNome(dados.getNome());
        prod.setPreco(dados.getPreco());
        prod.setCategoria(dados.getCategoria());

        return produtoRepository.save(prod);
    }

    public Produto updateProduto(String id, Produto dados) {

        Produto prodUpdate = produtoRepository.findById(id).get();

        if(prodUpdate != null) {
            prodUpdate.setCodigoBarras(dados.getCodigoBarras());
            prodUpdate.setNome(dados.getNome());
            prodUpdate.setPreco(dados.getPreco());
            prodUpdate.setCategoria(dados.getCategoria());

            return produtoRepository.save(prodUpdate); // Salva no BD
        }

        return null;
    }

    public void deleteProduto(String id) {
        produtoRepository.deleteById(id);
    }

}
