package Locadora;

import java.time.LocalDate;
import java.util.ArrayList;

public class Locacao {

  private ArrayList<Cliente> cliente;
  private ArrayList<Veiculo> veiculos;
  private LocalDate dataInicio;
  private LocalDate dataPrevistaDevolucao;
  private LocalDate dataDevolucao;
  private double valor;
  private double multa;
  private int status;

  public Locacao(ArrayList<Cliente> clientes, ArrayList<Veiculo> veiculos, LocalDate dataInicio,
      LocalDate dataPrevistaDevolucao, LocalDate dataDevolucao, double valor, double multa, int status) {
    this.cliente = clientes;
    this.veiculos = veiculos;
    this.dataInicio = dataInicio;
    this.dataDevolucao = dataDevolucao;
    this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    this.valor = valor;
    this.multa = multa;
    this.status = status;
  }

  public Locacao() {
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public ArrayList<Cliente> getCliente() {
    return cliente;
  }

  public void setCliente(ArrayList<Cliente> cliente) {
    this.cliente = cliente;
  }

  public ArrayList<Veiculo> getVeiculos() {
    return veiculos;
  }

  public void setVeiculos(ArrayList<Veiculo> veiculos) {
    this.veiculos = veiculos;
  }

  public LocalDate getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(LocalDate dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDate getdataDevolucao() {
    return dataDevolucao;
  }

  public void setdataDevolucao(LocalDate dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public LocalDate getdataPrevistaDevolucao() {
    return dataPrevistaDevolucao;
  }

  public void setdataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
    this.dataPrevistaDevolucao = dataPrevistaDevolucao;
  }

  public double getvalor() {
    return valor;
  }

  public void setvalor(double valor) {
    this.valor = valor;
  }

  public double getMulta() {
    return multa;
  }

  public void setMulta(double multa) {
    this.multa = multa;
  }

}
