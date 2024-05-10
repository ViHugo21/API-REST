package br.com.descomplica.springBoot.repository;

import br.com.descomplica.springBoot.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
