package Locadora;

import java.util.Scanner;

public class GerenciarCaixa {

  Scanner sc = new Scanner(System.in);

  public void gerenciarCaixa() {

    int opcao;
    Caixa caixa = new Caixa();

    do {

      System.out.println("1 - Pagamento de locação");
      System.out.println("2 - Relatório total arrecadado");
      System.out.println("3 - Relatório total arrecadado por periodo");
      System.out.println("4 - Relatório total à receber");
      System.out.println("0 - Sair");
      opcao = sc.nextInt();
      sc.nextLine();

      switch (opcao) {
        case 1:
          caixa.pagamentoLocacao();
          break;
        case 2:
          caixa.totalArrecadado();
          break;
        case 3:
          caixa.totalArrecadadoPorPeriodo();
          break;
        case 4:
          caixa.totalAReceber();
          break;
        case 0:
          break;
        default:
          break;
      }

    } while (opcao != 0);
  }

}
