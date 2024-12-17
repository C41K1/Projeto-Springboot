package br.edu.utfpr.textus.repository;

import br.edu.utfpr.textus.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}