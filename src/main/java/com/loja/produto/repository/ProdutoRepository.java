package com.loja.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.loja.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	//	Optional<Produto>findByCodigo(String codigo);
	
	@Query("SELECT f FROM Produto f WHERE f.codigo LIKE %?1%")
	List<Produto> findByCodigo(String codigo);
	
}
