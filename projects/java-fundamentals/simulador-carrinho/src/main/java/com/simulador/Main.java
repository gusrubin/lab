package com.simulador;

import java.util.Scanner;

/**
 * @author Gustavo Rubin
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Carrinho carrinho = new Carrinho();

    while (true) {
      System.out.println("\n--- Menu do Carrinho ---");
      System.out.println("1. Adicionar produto");
      System.out.println("2. Remover produto");
      System.out.println("3. Exibir carrinho");
      System.out.println("4. Calcular total");
      System.out.println("5. Sair");
      System.out.print("Escolha uma opção: ");

      String opcao = scanner.nextLine();

      switch (opcao) {
        case "1":
          System.out.print("Nome do produto: ");
          String nome = scanner.nextLine();
          System.out.print("Preço unitário: ");
          double preco = Double.parseDouble(scanner.nextLine());
          System.out.print("Quantidade: ");
          int quantidade = Integer.parseInt(scanner.nextLine());

          Produto produto = new Produto();
          produto.setNome(nome);
          produto.setPrecoUnitario(preco);
          carrinho.adicionarProduto(produto, quantidade);
          break;

        case "2":
          System.out.print("Nome do produto a remover: ");
          String nomeRemover = scanner.nextLine();
          carrinho.removerProduto(nomeRemover);
          break;

        case "3":
          carrinho.exibirCarrinho();
          break;

        case "4":
          double total = carrinho.calcularTotal();
          System.out.printf("Total do carrinho: R$ %.2f%n", total);
          break;

        case "5":
          System.out.println("Encerrando...");
          scanner.close();
          return;

        default:
          System.out.println("Opção inválida.");
      }
    }
  }
}
