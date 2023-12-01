package Locadora;

import java.util.Scanner;
import java.util.ArrayList;

public class GerenciarVeiculo {

  public void gerVeiculos(Scanner sc, ArrayList<Veiculo> veiculos) {
    int opcao;
    do {

      System.out.println("1 - Cadastrar veículo");
      System.out.println("2 - Remover veículo");
      System.out.println("3 - Listar veículos");
      System.out.println("4 - Buscar veículo");
      System.out.println("5 - Alterar veículo");
      System.out.println("0 - Sair");
      opcao = sc.nextInt();
      sc.nextLine();
      switch (opcao) {
        case 1:
          cadastrarVeiculo(sc, veiculos);
          break;
        case 2:
          removerVeiculo(sc, veiculos, null, null);
          break;
        case 3:
          listarVeiculos(sc, veiculos, null, null);
          break;
        case 4:
          buscarVeiculo(sc, veiculos, null, null);
          break;
        case 5:
          alterarVeiculo(sc, veiculos, null, null);
          break;
        case 0:
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }

    } while (opcao != 0);

  }

  public void cadastrarVeiculo(Scanner sc, ArrayList<Veiculo> veiculos) {
    System.out.println("1 - Carro");
    System.out.println("2 - Caminhao");
    System.out.println("3 - Sair");
    int op = sc.nextInt();
    sc.nextLine();
    if (op == 3)
      return;

    System.out.println("Digite a placa do veículo: ");
    String placa = sc.nextLine();

    System.out.println("Digite o ano do modelo do veículo: ");
    int anoModelo = sc.nextInt();
    sc.nextLine();

    System.out.println("Digite o ano de fabricação do veículo: ");
    int anoFabricacao = sc.nextInt();
    sc.nextLine();

    System.out.println("Digite a marca do veículo: ");
    String marca = sc.nextLine();

    System.out.println("Digite o modelo do veículo: ");
    String modelo = sc.nextLine();

    if (op == 1) {

      System.out.println("Digite a quantidade de portas do veículo: ");
      int qtdPortas = sc.nextInt();
      sc.nextLine();

      System.out.println("Digite a quantidade de passageiros do veículo: ");
      int qtdPassageiros = sc.nextInt();
      sc.nextLine();

      Veiculo carro = new Carro(placa, modelo, marca, anoFabricacao, anoModelo, qtdPassageiros, qtdPortas);
      veiculos.add(carro);
      System.out.println("Veículo cadastrado com sucesso!");
    } else if (op == 2) {

      System.out.println("Digite a capacidade de carga do veículo: ");
      float capacidadeCarga = sc.nextFloat();
      sc.nextLine();

      System.out.println("Digite a quantidade de eixos do veículo: ");
      int qtdEixos = sc.nextInt();
      sc.nextLine();

      Veiculo caminhao = new Caminhao(placa, modelo, marca, anoFabricacao, anoModelo, capacidadeCarga, qtdEixos);
      veiculos.add(caminhao);
      System.out.println("Veículo cadastrado com sucesso!");

    } else {
      System.out.println("Opção inválida!");
      return;
    }
  }

  public void removerVeiculo(Scanner sc, ArrayList<Veiculo> veiculos, ArrayList<Carro> carros,
      ArrayList<Caminhao> caminhoes) {
    int pos = -1; // initialize pos to -1
    System.out.println("1 - Carros cadastrados");
    System.out.println("2 - Caminhões cadastrados");
    System.out.println("3 - Sair");
    int op = sc.nextInt();
    sc.nextLine();

    if (op == 1) {
      System.out.println("Digite a placa do veículo: ");
      String buscarplaca = sc.nextLine();
      for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i) instanceof Carro && veiculos.get(i).getPlaca().equals(buscarplaca)) {
          pos = i;
          break;
        }
      }
      if (pos != -1) { // check if a vehicle was found
        veiculos.remove(pos);
        System.out.println("Veículo removido com sucesso!");
      } else {
        System.out.println("Veículo não encontrado!");
      }
    } else if (op == 2) {
      System.out.println("Digite a placa do veículo: ");
      String buscarplaca = sc.nextLine();
      for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i) instanceof Caminhao && veiculos.get(i).getPlaca().equals(buscarplaca)) {
          pos = i;
          break;
        }
      }
      if (pos != -1) { // check if a vehicle was found
        veiculos.remove(pos);
        System.out.println("Veículo removido com sucesso!");
      } else {
        System.out.println("Veículo não encontrado!");
      }
    }
  }

  public void listarVeiculos(Scanner sc, ArrayList<Veiculo> veiculos, ArrayList<Carro> carros,
      ArrayList<Caminhao> caminhoes) {
    System.out.println("1 - Carros cadastrados");
    System.out.println("2 - Caminhões cadastrados");
    System.out.println("3 - Sair");
    int op = sc.nextInt();
    sc.nextLine();

    if (op == 1) {
      for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i) instanceof Carro) {
          Carro carro = (Carro) veiculos.get(i);
          System.out.println("Marca: " + veiculos.get(i).getMarca());
          System.out.println("Modelo: " + veiculos.get(i).getModelo());
          System.out.println("Placa: " + veiculos.get(i).getPlaca());
          System.out.println("Ano de fabricação: " + veiculos.get(i).getAnoFabricacao());
          System.out.println("Ano do modelo: " + veiculos.get(i).getAnoModelo());
          System.out.println("Quantidade de passageiros: " + carro.getcapacidadePassageiros());
          System.out.println("Quantidade de portas: " + carro.getquantidadePortas());
        } else if (op == 2) {
          for (int x = 0; x < veiculos.size(); x++) {
            if (veiculos.get(i) instanceof Caminhao) {
              Caminhao caminhao = (Caminhao) veiculos.get(x);
              System.out.println("Marca: " + veiculos.get(x).getMarca());
              System.out.println("Modelo: " + veiculos.get(x).getModelo());
              System.out.println("Placa: " + veiculos.get(x).getPlaca());
              System.out.println("Ano de fabricação: " + veiculos.get(x).getAnoFabricacao());
              System.out.println("Ano do modelo: " + veiculos.get(x).getAnoModelo());
              System.out.println("Capacidade de carga: " + caminhao.getCapacidadeCarga());
              System.out.println("Quantidade de eixos: " + caminhao.getNumeroEixos());
            }
          }
        }
      }
    }

  }

  public void buscarVeiculo(Scanner sc, ArrayList<Veiculo> veiculos, ArrayList<Carro> carros,
      ArrayList<Caminhao> caminhoes) {
    System.out.println("1 - Carros cadastrados");
    System.out.println("2 - Caminhões cadastrados");
    System.out.println("3 - Sair");
    int op = sc.nextInt();
    sc.nextLine();

    if (op == 1) {
      for (int i = 0; i < veiculos.size(); i++) {
        System.out.println("Digite a placa do carro: ");
        String buscarplaca = sc.nextLine();

        if (veiculos.get(i) instanceof Carro && buscarplaca.equals(veiculos.get(i).getPlaca())) {
          Carro carro = (Carro) veiculos.get(i);
          System.out.println("Marca: " + veiculos.get(i).getMarca());
          System.out.println("Modelo: " + veiculos.get(i).getModelo());
          System.out.println("Placa: " + veiculos.get(i).getPlaca());
          System.out.println("Ano de fabricação: " + veiculos.get(i).getAnoFabricacao());
          System.out.println("Ano do modelo: " + veiculos.get(i).getAnoModelo());
          System.out.println("Quantidade de passageiros: " + carro.getcapacidadePassageiros());
          System.out.println("Quantidade de portas: " + carro.getquantidadePortas());
        } else if (op == 2) {
          for (int x = 0; x < veiculos.size(); x++) {
            if (veiculos.get(i) instanceof Caminhao) {
              Caminhao caminhao = (Caminhao) veiculos.get(x);
              System.out.println("Marca: " + veiculos.get(x).getMarca());
              System.out.println("Modelo: " + veiculos.get(x).getModelo());
              System.out.println("Placa: " + veiculos.get(x).getPlaca());
              System.out.println("Ano de fabricação: " + veiculos.get(x).getAnoFabricacao());
              System.out.println("Ano do modelo: " + veiculos.get(x).getAnoModelo());
              System.out.println("Capacidade de carga: " + caminhao.getCapacidadeCarga());
              System.out.println("Quantidade de eixos: " + caminhao.getNumeroEixos());
            }
          }
        } else {
          System.out.println("Veículo não encontrado!");
          break;
        }
      }
    }

  }

  public void alterarVeiculo(Scanner sc, ArrayList<Veiculo> veiculos, ArrayList<Carro> carros,
      ArrayList<Caminhao> caminhoes) {

    System.out.println("1 - Carros cadastrados");
    System.out.println("2 - Caminhões cadastrados");
    System.out.println("3 - Sair");
    int op = sc.nextInt();
    sc.nextLine();

    if (op == 1) {

      for (int i = 0; i < veiculos.size(); i++) {
        Carro carro = (Carro) veiculos.get(i);

        if (veiculos.get(i) instanceof Carro) {

          System.out.println("Marca: " + veiculos.get(i).getMarca());
          System.out.println("Modelo: " + veiculos.get(i).getModelo());
          System.out.println("Placa: " + veiculos.get(i).getPlaca());
          System.out.println("Ano de fabricação: " + veiculos.get(i).getAnoFabricacao());
          System.out.println("Ano do modelo: " + veiculos.get(i).getAnoModelo());
          System.out.println("Quantidade de passageiros: " + carro.getcapacidadePassageiros());
          System.out.println("Quantidade de portas: " + carro.getquantidadePortas());
          System.out.println("");

          System.out.println("Digite a placa do veículo: ");
          String buscarplaca = sc.nextLine();

          if (buscarplaca.equals(veiculos.get(i).getPlaca())) {

            System.out.println("Digite a marca do veículo: ");
            String marca = sc.nextLine();

            System.out.println("Digite o modelo do veículo: ");
            String modelo = sc.nextLine();

            System.out.println("Digite a placa do veículo: ");
            String placa = sc.nextLine();

            System.out.println("Digite o ano de fabricacao do veículo: ");
            int anoFabricacao = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o ano do modelo do veículo: ");
            int anoModelo = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite quantidade de passageiros do veículo: ");
            int qtdPassageiros = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite a quantidade de portas do veículo: ");
            int qtdPortas = sc.nextInt();
            sc.nextLine();

            carro.setMarca(marca);
            carro.setModelo(modelo);
            carro.setPlaca(placa);
            carro.setAnoModelo(anoModelo);
            carro.setcapacidadePassageiros(qtdPassageiros);
            carro.setquantidadePortas(qtdPortas);
            carro.setAnoFabricacao(anoFabricacao);
            System.out.println("Veículo alterado com sucesso!");
          }
        } else if (op == 2) {
          for (int x = 0; x < veiculos.size(); x++) {
            if (veiculos.get(i) instanceof Caminhao) {
              Caminhao caminhao = (Caminhao) veiculos.get(x);
              System.out.println("Marca: " + veiculos.get(x).getMarca());
              System.out.println("Modelo: " + veiculos.get(x).getModelo());
              System.out.println("Placa: " + veiculos.get(x).getPlaca());
              System.out.println("Ano de fabricação: " + veiculos.get(x).getAnoFabricacao());
              System.out.println("Ano do modelo: " + veiculos.get(x).getAnoModelo());
              System.out.println("Capacidade de carga: " + caminhao.getCapacidadeCarga());
              System.out.println("Quantidade de eixos: " + caminhao.getNumeroEixos());
            }
          }
        }
      }
    }
  }
}
