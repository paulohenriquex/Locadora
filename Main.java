package Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    int opcao = -1;

    GerenciarVeiculo gerveiculo = new GerenciarVeiculo();
    GerenciarCliente gercliente = new GerenciarCliente();
    GerenciarLocacao gerlocacao = new GerenciarLocacao();
    GerenciarCaixa gercaixa = new GerenciarCaixa();
    ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    ArrayList<Fisica> clienteFisico = new ArrayList<Fisica>();
    ArrayList<Juridica> clienteJuridico = new ArrayList<Juridica>();
    ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
    ArrayList<Cliente> cliente = new ArrayList<Cliente>();
    Agenda agenda = new Agenda();

    do {

      System.out.println("1 - Veículo");
      System.out.println("2 - Cliente");
      System.out.println("3 - Locação");
      System.out.println("4 - Caixa");
      System.out.println("5 - Agenda");
      System.out.println("0 - Sair");
      System.out.println("");
      opcao = sc.nextInt("Teste mais maluco ainda");
      System.out.println("");
      sc.nextLine();

      switch (opcao) {
        case 1:
          gerveiculo.gerVeiculos(sc, veiculos);
          break;
        case 2:
          gercliente.gerCliente(sc, cliente, clienteFisico, clienteJuridico);
          break;
        case 3:
          gerlocacao.gerLocacao(sc, locacoes, veiculos, cliente);
          break;
        case 4:
          gercaixa.gerenciarCaixa();
          break;
        case 5:
          agenda.agendar();
          break;
        case 0:
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }

    } while (opcao != 0);
    sc.close();
  }

}
