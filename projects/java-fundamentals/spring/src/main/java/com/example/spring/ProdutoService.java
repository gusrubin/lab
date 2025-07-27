package com.example.spring;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * @author Gustavo Rubin
 */
@Service
public class ProdutoService {

  private final ProdutoRepository repository;

  public ProdutoService(ProdutoRepository repository) {
    this.repository = repository;
  }

  public List<Produto> listar() {
    return repository.findAll();
  }

  public Optional<Produto> buscarPorId(Long id) {
    return repository.findById(id);
  }

  public Produto salvar(Produto produto) {
    return repository.save(produto);
  }

  public void deletar(Long id) {
    repository.deleteById(id);
  }
}
