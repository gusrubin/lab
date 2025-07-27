package com.simulador;

/**
 * @author Gustavo Rubin
 */
public class Produto {
  private String nome;
  private double precoUnitario;

  public String getNome() {
    return nome;
  }

  public double getPrecoUnitario() {
    return precoUnitario;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPrecoUnitario(double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }
}
