package com.exemplo;

import com.exemplo.abstracao.Pagamento;
import com.exemplo.abstracao.PagamentoCredito;
import com.exemplo.abstracao.PagamentoDebito;
import com.exemplo.heranca.Aluno;
import com.exemplo.heranca.Pessoa;

/**
 * @author Gustavo Rubin
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome");

    Pessoa p1 = new Pessoa("Carlos", 40);
    Aluno a1 = new Aluno("Marina", 20, "Engenharia");

    // Herança: Aluno herda de Pessoa
    p1.apresentar(); // chama método da classe Pessoa
    a1.apresentar(); // chama método sobrescrito da classe Aluno

    // Polimorfismo: variável do tipo Pessoa armazenando um Aluno
    Pessoa p2 = new Aluno("João", 22, "Medicina");
    p2.apresentar(); // chama o método sobrescrito da classe Aluno

    Pagamento pagamento1 = new PagamentoCredito(150.00);
    Pagamento pagamento2 = new PagamentoDebito(75.50);

    pagamento1.processarPagamento(); // abstração + polimorfismo
    pagamento2.processarPagamento();
  }
}
