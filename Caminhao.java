package Locadora;

public class Caminhao extends Veiculo {
  private float capacidadeCarga;
  private float numeroEixos;

  public Caminhao(String placa, String modelo, String marca, int anoFabricacao, int anoModelo, float capacidadeCarga,
      float numeroEixos) {
    super(placa, modelo, marca, anoFabricacao, anoModelo);
    this.capacidadeCarga = capacidadeCarga;
    this.numeroEixos = numeroEixos;
  }

  public float getCapacidadeCarga() {
    return capacidadeCarga;
  }

  public void setCapacidadeCarga(float capacidadeCarga) {
    this.capacidadeCarga = capacidadeCarga;
  }

  public float getNumeroEixos() {
    return numeroEixos;
  }

  public void setNumeroEixos(float numeroEixos) {
    this.numeroEixos = numeroEixos;
  }

}
