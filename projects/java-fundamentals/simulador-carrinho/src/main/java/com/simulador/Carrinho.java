package com.simulador;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gustavo Rubin
 */
public class Carrinho {
  private List<ItemCarrinho> itens = new ArrayList<>();

  public void adicionarProduto(Produto produto, int quantidade) {
    for (ItemCarrinho item : itens) {
      if (item.getProduto().getNome().equalsIgnoreCase(produto.getNome())) {
        return;
      }
    }
    itens.add(new ItemCarrinho(produto, quantidade));
  }

  public void removerProduto(String nomeProduto) {
    itens.removeIf(item -> item.getProduto().getNome().equalsIgnoreCase(nomeProduto));
  }

  public void exibirCarrinho() {
    if (itens == null || itens.isEmpty()) {
      System.out.println("O carrinho está vazio.");
      return;
    }

    System.out.println("\n================= CARRINHO DE COMPRAS =================");
    System.out.printf(
        "%-25s %-10s %-15s %-15s%n", "Produto", "Qtd", "Preço Unitário", "Total Item");
    System.out.println("--------------------------------------------------------");

    double totalGeral = 0;

    for (ItemCarrinho item : itens) {
      Produto produto = item.getProduto();
      int qtd = item.getQuantidade();
      double preco = produto.getPrecoUnitario();
      double totalItem = item.getTotal();
      totalGeral += totalItem;

      System.out.printf(
          "%-25s %-10d R$ %-13.2f R$ %-13.2f%n", produto.getNome(), qtd, preco, totalItem);
    }

    System.out.println("--------------------------------------------------------");
    System.out.printf("%-51s R$ %.2f%n", "TOTAL GERAL:", totalGeral);
    System.out.println("========================================================\n");
  }

  public double calcularTotal() {
    double total = 0;
    for (ItemCarrinho item : itens) {
      total += item.getTotal();
    }
    return total;
  }
}
