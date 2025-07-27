package com.exemplo.heranca;

/**
 * @author Gustavo Rubin
 */
public class Pessoa {
  // Atributos privados (encapsulamento)
  private String nome;
  private int idade;

  // Construtor
  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  // Métodos públicos para acessar os atributos (getters)
  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  // Método para simular uma ação
  public void apresentar() {
    System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
  }
}
