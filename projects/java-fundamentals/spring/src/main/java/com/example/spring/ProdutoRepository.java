package com.example.spring;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gustavo Rubin
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
