package com.exemplo.heranca;

/**
 * @author Gustavo Rubin
 */
public class Aluno extends Pessoa {
  private String curso;

  public Aluno(String nome, int idade, String curso) {
    super(nome, idade); // chama o construtor da superclasse Pessoa
    this.curso = curso;
  }

  public String getCurso() {
    return curso;
  }

  // Sobrescreve o método apresentar (polimorfismo)
  @Override
  public void apresentar() {
    System.out.println(
        "Olá, sou " + getNome() + ", tenho " + getIdade() + " anos e estudo " + curso + ".");
  }
}
