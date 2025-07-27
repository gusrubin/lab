package com.exemplo.abstracao;

/**
 * @author Gustavo Rubin
 */
public class PagamentoDebito extends Pagamento {

  public PagamentoDebito(double valor) {
    super(valor);
  }

  @Override
  public void processarPagamento() {
    System.out.println("Processando pagamento de R$" + valor + " no débito.");
    System.out.println("Pagamento aprovado imediatamente.");
  }
}
