package Locadora;

import java.time.LocalDate;

public class Fisica extends Cliente {
  private String cpf;
  private LocalDate dataNascimento;

  public Fisica(String nome, String telefone, String endereco, String cpf, LocalDate dataNascimento) {
    super(nome, telefone, endereco);
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
  }

  public Fisica() {
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public char[] getDocumento() {
    return null;
  }

}
