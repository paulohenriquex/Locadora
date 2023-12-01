package Locadora;

public class Juridica extends Cliente {

  private String cnpj;

  public Juridica(String nome, String telefone, String endereco, String cnpj) {
    super(nome, telefone, endereco);
    this.cnpj = cnpj;
  }

  public Juridica() {
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public char[] getDocumento() {
    return null;
  }

}
