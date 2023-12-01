package Locadora;

public class Veiculo {

  private String marca;
  private String modelo;
  private int anoFabricacao;
  private int anoModelo;
  private String placa;

  public Veiculo(String placa, String modelo, String marca, int anoFabricacao, int anoModelo) {
    this.placa = placa;
    this.modelo = modelo;
    this.marca = marca;
    this.anoFabricacao = anoFabricacao;
    this.anoModelo = anoModelo;
  }

  public int getAnoFabricacao() {
    return anoFabricacao;
  }

  public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
  }

  public int getAnoModelo() {
    return anoModelo;
  }

  public void setAnoModelo(int anoModelo) {
    this.anoModelo = anoModelo;
  }

  public Veiculo() {
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

}
