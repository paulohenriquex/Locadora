package Locadora;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class GerenciarCliente {

  public void gerCliente(Scanner sc, ArrayList<Cliente> cliente, ArrayList<Fisica> clienteFisico,
      ArrayList<Juridica> clienteJuridico) {

    int opcao;
    do {

      System.out.println("1 - Cadastrar cliente");
      System.out.println("2 - Remover cliente");
      System.out.println("3 - Listar clientes");
      System.out.println("4 - Buscar cliente");
      System.out.println("5 - Alterar cliente");
      System.out.println("0 - Sair");
      opcao = sc.nextInt();
      sc.nextLine();

      switch (opcao) {
        case 1:
          cadastrarCliente(sc, cliente, clienteFisico, clienteJuridico);
          break;
        case 2:
          exluirCliente(sc, cliente);
          break;
        case 3:
          listarClientes(cliente);
          break;
        case 4:
          buscarCliente(sc, cliente);
          break;
        case 5:
          alterarCliente(sc, cliente);
          break;
        case 0:
          break;
        default:
          System.out.println("Opção inválida!");
          break;
      }

    } while (opcao != 0);
  }

  public void cadastrarCliente(Scanner sc, ArrayList<Cliente> cliente, ArrayList<Fisica> clienteFisico,
      ArrayList<Juridica> clienteJuridico) {
    LocalDate dataNascimento = null;
    int op = -1;

    System.out.println("Digite o nome do cliente: ");
    String nome = sc.nextLine();

    System.out.println("Digite o telefone do cliente: ");
    String telefone = sc.nextLine();

    System.out.println("Digite o endereço do cliente: ");
    String endereco = sc.nextLine();

    System.out.println("Digite o CPF/CNPJ do cliente: ");
    String numero = sc.nextLine();

    if (numero.length() == 11) {
      op = 1;
    } else if (numero.length() == 14) {
      op = 2;
    } else {
      System.out.println("CPF/CNPJ inválido!");
      return;
    }

    if (op == 1) {

      try {
        System.out.println("Digite a data de nascimento do cliente (dd/mm/yyyy): ");
        String dataNascimentoStr = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inputDate = LocalDate.parse(dataNascimentoStr, formatter);
        dataNascimento = inputDate;

        Fisica fisica = new Fisica(nome, telefone, endereco, numero, dataNascimento);
        cliente.add(fisica);
      } catch (Exception e) {
        System.out.println("Data inválida!");
      }
    } else if (op == 2) {

      Juridica juridica = new Juridica(nome, telefone, endereco, numero);
      cliente.add(juridica);
    }
  }

  public void listarClientes(ArrayList<Cliente> clientes) {
    if (clientes.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
    } else {
      System.out.println("Lista de Clientes:");
      for (Cliente cliente : clientes) {
        if (cliente instanceof Fisica) {
          Fisica clienteFisico = (Fisica) cliente;
          System.out.println("Nome: " + cliente.getNome());
          System.out.println("Telefone: " + cliente.getTelefone());
          System.out.println("Endereço: " + cliente.getEndereco());
          System.out.println("CPF: " + clienteFisico.getCpf());
          System.out.println("Data de Nascimento: " + clienteFisico.getDataNascimento());
        } else if (cliente instanceof Juridica) {
          Juridica clienteJuridico = (Juridica) cliente;
          System.out.println("Nome: " + clienteJuridico.getNome());
          System.out.println("Telefone: " + clienteJuridico.getTelefone());
          System.out.println("Endereço: " + clienteJuridico.getEndereco());
          System.out.println("CNPJ: " + clienteJuridico.getCnpj());
        }
      }
    }
  }

  public void exluirCliente(Scanner sc, ArrayList<Cliente> clientes) {
    int op = -1;
    System.out.println();
    System.out.println("Digite o CPF/CNPJ do cliente: ");
    String numeroCli = sc.nextLine();
    if (numeroCli.length() == 11) {
      op = 1;
    } else if (numeroCli.length() == 14) {
      op = 2;
    } else {
      System.out.println("CPF/CNPJ inválido!");
      return;
    }

    for (Cliente cliente : clientes) {
      if (cliente instanceof Fisica && op == 1 && ((Fisica) cliente).getCpf().equals(numeroCli)) {
        Fisica clienteFisico = (Fisica) cliente;
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("CPF: " + clienteFisico.getCpf());
        System.out.println("Data de Nascimento: " + clienteFisico.getDataNascimento());
        System.out.println("Deseja excluir o cliente? (S/N)");
        String opcao = sc.nextLine();
        if (opcao.equals("S") || (opcao.equals("s"))) {
          clientes.remove(cliente);
          System.out.println("Cliente removido com sucesso!");
          break;
        } else {
          System.out.println("Cliente não removido!");
        }

      } else if (cliente instanceof Juridica && op == 2 && ((Juridica) cliente).getCnpj().equals(numeroCli)) {
        Juridica clienteJuridico = (Juridica) cliente;
        System.out.println("Nome: " + clienteJuridico.getNome());
        System.out.println("Telefone: " + clienteJuridico.getTelefone());
        System.out.println("Endereço: " + clienteJuridico.getEndereco());
        System.out.println("CNPJ: " + clienteJuridico.getCnpj());
        System.out.println("Deseja excluir o cliente? (S/N)");
        String opcao = sc.nextLine();
        if (opcao.equals("S") || (opcao.equals("s"))) {
          clientes.remove(cliente);
          System.out.println("Cliente removido com sucesso!");
          break;
        } else {
          System.out.println("Cliente não removido!");
        }
      } else {
        System.out.println("Cliente não encontrado!");
      }
    }
  }

  public void buscarCliente(Scanner sc, ArrayList<Cliente> clientes) {
    System.out.println("Digite o CPF do cliente: ");
    String buscarNumero = sc.nextLine();

    if (buscarNumero.length() == 11) {
      for (Cliente cliente : clientes) {
        Fisica clienteFisico = (Fisica) cliente;
        if (cliente instanceof Fisica && ((Fisica) cliente).getCpf().equals(buscarNumero)) {
          System.out.println("Nome: " + cliente.getNome());
          System.out.println("Telefone: " + cliente.getTelefone());
          System.out.println("Endereço: " + cliente.getEndereco());
          System.out.println("CPF: " + clienteFisico.getCpf());
          System.out.println("Data de Nascimento: " + clienteFisico.getDataNascimento());
        }
      }
    } else if (buscarNumero.length() == 14) {
      for (Cliente cliente : clientes) {
        Juridica clienteJuridico = (Juridica) cliente;
        if (cliente instanceof Juridica && ((Juridica) cliente).getCnpj().equals(buscarNumero)) {
          System.out.println("Nome: " + clienteJuridico.getNome());
          System.out.println("Telefone: " + clienteJuridico.getTelefone());
          System.out.println("Endereço: " + clienteJuridico.getEndereco());
          System.out.println("CNPJ: " + clienteJuridico.getCnpj());
        }

      }
    }
  }

  public void alterarCliente(Scanner sc, ArrayList<Cliente> clientes) {

    int op = -1;
    LocalDate novadataNascimento = null;
    System.out.println("Digite o CPF do cliente: ");
    String buscarNumero = sc.nextLine();
    sc.nextLine();

    if (buscarNumero.length() == 11) {
      op = 1;
    } else if (buscarNumero.length() == 14) {
      op = 2;
    } else {
      System.out.println("CPF/CNPJ inválido!");
      return;
    }
    if (op == 1) {

      for (Cliente cliente : clientes) {
        if (cliente instanceof Fisica && ((Fisica) cliente).getCpf().equals(buscarNumero)) {
          Fisica clienteFisico = (Fisica) cliente;
          System.out.println("Nome: " + cliente.getNome());
          System.out.println("Telefone: " + cliente.getTelefone());
          System.out.println("Endereço: " + cliente.getEndereco());
          System.out.println("CPF: " + clienteFisico.getCpf());
          System.out.println("Data de Nascimento: " + clienteFisico.getDataNascimento());
          System.out.println("Deseja alterar o cliente? (S/N)");
          String opcao = sc.nextLine();
          if (opcao.equals("S") || (opcao.equals("s"))) {
            clientes.remove(cliente);
            System.out.println("Digite o novo nome do cliente: ");
            String nome = sc.nextLine();

            System.out.println("Digite o novo telefone do cliente: ");
            String telefone = sc.nextLine();

            System.out.println("Digite o novo endereço do cliente: ");
            String endereco = sc.nextLine();

            System.out.println("Digite o novo CPF do cliente: ");
            String cpf = sc.nextLine();
            try {
              System.out.println("Digite a data de nascimento do cliente (dd/mm/yyyy): ");
              String dataNascimentoStr = sc.nextLine();

              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              LocalDate inputDate = LocalDate.parse(dataNascimentoStr, formatter);
              novadataNascimento = inputDate;

              Fisica fisica = new Fisica(nome, telefone, endereco, cpf, novadataNascimento);
              clientes.add(fisica);
            } catch (Exception e) {
              System.out.println("Data inválida!");
            }

          }
        }
      }
    } else if (op == 2) {
      System.out.println("Digite o CNPJ do cliente: ");
      String buscarCnpj = sc.nextLine();
      for (Cliente cliente : clientes) {
        if (cliente instanceof Juridica && ((Juridica) cliente).getCnpj().equals(buscarCnpj)) {
          Juridica clienteJuridico = (Juridica) cliente;
          System.out.println("Nome: " + clienteJuridico.getNome());
          System.out.println("Telefone: " + clienteJuridico.getTelefone());
          System.out.println("Endereço: " + clienteJuridico.getEndereco());
          System.out.println("CNPJ: " + clienteJuridico.getCnpj());
          System.out.println("Deseja alterar o cliente? (S/N)");
          String opcao = sc.nextLine();
          if (opcao.equals("S") || (opcao.equals("s"))) {
            clientes.remove(cliente);
            System.out.println("Digite o novo nome do cliente: ");
            String nome = sc.nextLine();

            System.out.println("Digite o novo telefone do cliente: ");
            String telefone = sc.nextLine();

            System.out.println("Digite o novo endereço do cliente: ");
            String endereco = sc.nextLine();

            System.out.println("Digite o novo CNPJ do cliente: ");
            String cnpj = sc.nextLine();
            Juridica juridica = new Juridica(nome, telefone, endereco, cnpj);
            clientes.add(juridica);
          }
        }
      }
    }
  }
}