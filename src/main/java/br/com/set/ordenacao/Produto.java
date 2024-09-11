package br.com.set.ordenacao;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto> {

  private Long codigo;
  private String nome;
  private double preco;
  private int quantidade;

  public Produto(Long codigo, String nome, double preco, int quantidade) {
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
  }

  @Override
  public int compareTo(@NotNull Produto produto) {
    return this.nome.compareTo(produto.getNome());
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto produto)) return false;
    return Double.compare(preco, produto.preco) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(preco);
  }

  @Override
  public String toString() {
    return STR."Produto{codigo=\{codigo}, nome='\{nome}', preco=\{preco}, quantidade=\{quantidade}}";
  }
}

class ComparatorPorPreco implements Comparator<Produto> {

  @Override
  public int compare(Produto o1, Produto o2) {
    return Double.compare(o1.getPreco(), o2.getPreco());
  }
}
