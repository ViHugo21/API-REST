package br.com.descomplica.springBoot.repository;

import br.com.descomplica.springBoot.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    @Query("SELECT p FROM Produto p WHERE p.categoria.id = :id")
    List<Produto> getAllProductsByCategoryId(@Param("id") String id);

}
