package com.exemplo.abstracao;

/**
 * @author Gustavo Rubin
 */
public class PagamentoCredito extends Pagamento {

  public PagamentoCredito(double valor) {
    super(valor);
  }

  @Override
  public void processarPagamento() {
    System.out.println("Processando pagamento de R$" + valor + " no crédito.");
    System.out.println("Pagamento aprovado com taxa de juros.");
  }
}
