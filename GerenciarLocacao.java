package Locadora;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class GerenciarLocacao {

  public void gerLocacao(Scanner sc, ArrayList<Locacao> locacoes, ArrayList<Veiculo> veiculos,
      ArrayList<Cliente> cliente) {
    int opcao;

    do {

      System.out.println("1 - Cadastrar locação");
      System.out.println("2 - Remover locação");
      System.out.println("3 - Listar locações");
      System.out.println("4 - Buscar locação");
      System.out.println("5 - Alterar locação");
      System.out.println("0 - Sair");
      opcao = sc.nextInt();
      sc.nextLine();

      switch (opcao) {

        case 1:
          cadastrarLocacao(sc, locacoes, veiculos, cliente);
          break;
        case 2:
          removerLocacoes();
          break;
        case 3:
          listarLocacoes(locacoes, veiculos, cliente);
          break;
        case 4:
          buscarLocacao();
          break;
        default:
          break;
      }

    } while (opcao != 0);
  }

  public void cadastrarLocacao(Scanner sc, ArrayList<Locacao> locacoes, ArrayList<Veiculo> veiculos,
      ArrayList<Cliente> clientes) {

    GerenciarCliente list = new GerenciarCliente();

    int posCli = -1;
    int posVei = -1;
    double multa = 0;
    LocalDate dataDevolucao = null;
    LocalDate dataPrevistaDevolucao = null;
    LocalDate dataInicio = null;
    int status = 0;
    int op = -1;

    list.listarClientes(clientes);

    System.out.println("Digite o CPF/CNPJ do cliente: ");
    String buscarNumero = sc.nextLine();

    if (buscarNumero.length() == 11) {
      op = 1;
    } else if (buscarNumero.length() == 14) {
      op = 2;
    } else {
      System.out.println("CPF/CNPJ inválido!");
      System.out.println("");
      return;
    }

    for (

        int i = 0; i < clientes.size(); i++) {
      Cliente cliente = clientes.get(i);
      if (cliente instanceof Fisica && op == 1) {
        Fisica fisica = (Fisica) cliente;
        if (fisica.getCpf().equals(buscarNumero)) {
          posCli = i;
          break;
        }
      } else if (cliente instanceof Juridica && op == 2) {
        Juridica juridica = (Juridica) cliente;
        if (juridica.getCnpj().equals(buscarNumero)) {
          posCli = i;
          break;
        }
      } else {
        System.out.println("Cliente não encontrado!");
        System.out.println("");
        return;
      }
    }

    if (posCli == -1) {
      System.out.println("CPF/CNPJ não encontrado!");
      System.out.println("");
      return;
    }

    System.out.println("1 - Carro");
    System.out.println("2 - Caminhão");
    System.out.println("0 - Sair");
    int op1 = sc.nextInt();
    sc.nextLine();
    System.out.println("");

    for (int i = 0; i < veiculos.size(); i++) {
      Veiculo veiculo = veiculos.get(i);
      if (veiculo instanceof Carro && op1 == 1) {
        Carro carro = (Carro) veiculo;
        System.out.println("Placa: " + carro.getPlaca());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("");
      } else if (veiculo instanceof Caminhao && op1 == 2) {
        Caminhao caminhao = (Caminhao) veiculo;
        System.out.println("Placa: " + caminhao.getPlaca());
        System.out.println("Modelo: " + caminhao.getModelo());
        System.out.println("Marca: " + caminhao.getMarca());
        System.out.println("");
      } else {
        System.out.println("Não há veículos cadastrados!");
        return;
      }
    }

    System.out.println("Digite a placa do veículo: ");
    String buscarplaca = sc.nextLine();

    for (int i = 0; i < veiculos.size(); i++) {
      Veiculo veiculo = veiculos.get(i);
      if (veiculo instanceof Carro) {
        Carro carro = (Carro) veiculo;
        if (carro.getPlaca().equals(buscarplaca)) {
          System.out.println("Placa: " + carro.getPlaca());
          System.out.println("Modelo: " + carro.getModelo());
          System.out.println("Marca: " + carro.getMarca());
          System.out.println("");
          posVei = i;
        }
      }
    }

    if (posVei == -1) {
      System.out.println("Placa não encontrada!");
      System.out.println("");
      return;
    }

    // Entrada e validação da data de início
    boolean dataInicioValida = false;
    do {
      try {
        System.out.println("Digite a data de inicio (dd/MM/yyyy): ");
        String dataInicioStr = sc.nextLine();
        dataInicio = LocalDate.parse(dataInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataInicio.isAfter(LocalDate.now()) || dataInicio.isEqual(LocalDate.now())) {
          dataInicioValida = true;
        } else {
          System.out.println("Data de início deve ser uma data futura.");
        }
      } catch (Exception e) {
        System.out.println("Formato de data inválido!");
      }
    } while (!dataInicioValida);

    // Entrada e validação da data prevista de devolução
    boolean dataPrevistaValida = false;
    do {
      try {
        System.out.println("Digite a data prevista de devolução (dd/MM/yyyy): ");
        String dataPrevistaStr = sc.nextLine();
        dataPrevistaDevolucao = LocalDate.parse(dataPrevistaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataPrevistaDevolucao.isAfter(dataInicio)) {
          dataPrevistaValida = true;
        } else {
          System.out.println("Data prevista de devolução deve ser após a data de início.");
        }
      } catch (Exception e) {
        System.out.println("Formato de data inválido!");
      }
    } while (!dataPrevistaValida);

    // Entrada e validação da data de devolução
    boolean dataDevolucaoValida = false;
    do {
      try {
        System.out.println("Digite a data de devolução (dd/MM/yyyy): ");
        String dataDevolucaoStr = sc.nextLine();
        dataDevolucao = LocalDate.parse(dataDevolucaoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataDevolucao.isAfter(dataInicio)) {
          dataDevolucaoValida = true;
        } else {
          System.out.println("Data de devolução inválida!");
        }
      } catch (Exception e) {
        System.out.println("Formato de data inválido!");
      }
    } while (!dataDevolucaoValida);

    System.out.println("Digite o valor da locação: ");
    double valor = sc.nextDouble();

    long dias = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
    System.out.println("Dias de atraso: " + dias);

    double txjuros = 0.0028;
    if (dias > 0) {
      multa = (valor * Math.pow((1 + txjuros), dias));
    }

    status = 1;

    Veiculo veiculo = veiculos.get(posVei);
    veiculos.add(veiculo);

    Cliente cliente = clientes.get(posCli);
    clientes.add(cliente);

    Locacao locacao = new Locacao(clientes, veiculos, dataInicio, dataPrevistaDevolucao, dataDevolucao, valor, multa,
        status);
    locacoes.add(locacao);
  }

  public void removerLocacoes() {

  }

  public void listarLocacoes(ArrayList<Locacao> locacoes, ArrayList<Veiculo> veiculos,
      ArrayList<Cliente> clientes) {
    for (int i = 0; i < locacoes.size(); i++) {
      Locacao locacao = locacoes.get(i);
      System.out.println("Locação " + (i + 1));
      System.out.println("Cliente: " + locacao.getCliente().get(i).getNome());
      System.out.println("Marca: " + locacao.getVeiculos().get(i).getMarca());
      System.out.println("Modelo: " + locacao.getVeiculos().get(i).getModelo());
      System.out.println("Data de início: " + locacao.getDataInicio());
      System.out.println("Data prevista de devolução: " + locacao.getdataPrevistaDevolucao());
      System.out.println("Data de devolução: " + locacao.getdataDevolucao());
      System.out.println("Valor: " + locacao.getvalor());
      System.out.println("Multa: " + locacao.getMulta());
      System.out.println("Status: " + locacao.getStatus());
      System.out.println("");
    }
  }

  public void buscarLocacao() {

  }
}
