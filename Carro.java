package Locadora;

public class Carro extends Veiculo {

  private int capacidadePassageiros;
  private int quantidadePortas;

  public Carro(String placa, String modelo, String marca, int anoFabricacao, int anoModelo, int capacidadePassageiros,
      int quantidadePortas) {
    super(placa, modelo, marca, anoFabricacao, anoModelo);
    this.capacidadePassageiros = capacidadePassageiros;
    this.quantidadePortas = quantidadePortas;

  }

  public int getcapacidadePassageiros() {
    return capacidadePassageiros;
  }

  public void setcapacidadePassageiros(int capacidadePassageiros) {
    this.capacidadePassageiros = capacidadePassageiros;
  }

  public int getquantidadePortas() {
    return quantidadePortas;
  }

  public void setquantidadePortas(int quantidadePortas) {
    this.quantidadePortas = quantidadePortas;
  }

}
