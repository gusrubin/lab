package com.example.spring;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gustavo Rubin
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  private final ProdutoService service;

  public ProdutoController(ProdutoService service) {
    this.service = service;
  }

  @GetMapping
  public List<Produto> listar() {
    return service.listar();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    return service
        .buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Produto criar(@RequestBody Produto produto) {
    return service.salvar(produto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
    return service
        .buscarPorId(id)
        .map(
            p -> {
              p.setNome(produto.getNome());
              p.setPreco(produto.getPreco());
              return ResponseEntity.ok(service.salvar(p));
            })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletar(@PathVariable Long id) {
    return service
        .buscarPorId(id)
        .map(
            p -> {
              service.deletar(id);
              return ResponseEntity.noContent().build();
            })
        .orElse(ResponseEntity.notFound().build());
  }
}
