package com.exemplo.abstracao;

/**
 * @author Gustavo Rubin
 */
public abstract class Pagamento {
  protected double valor;

  public Pagamento(double valor) {
    this.valor = valor;
  }

  // Método abstrato: cada tipo de pagamento define sua lógica
  public abstract void processarPagamento();

  public double getValor() {
    return valor;
  }
}
