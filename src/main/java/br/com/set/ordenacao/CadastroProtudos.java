package br.com.set.ordenacao;

import br.com.set.ExceptionSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProtudos {
  //atributos
  private Set<Produto> produtoSet;

  public CadastroProtudos() {
    this.produtoSet = new HashSet<>();
  }

  public void cadastrarProduto(long codigo, String nome, double preco, int quantidade) {
    this.produtoSet.add(new Produto(codigo, nome, preco, quantidade));
  }

  public Set<Produto> exibirProdutosPorNome() {
    Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
    if (!produtoSet.isEmpty()) {
      return produtoPorNome;
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public Set<Produto> exibirProdutoPorPreco() {
    Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
    if (!produtoSet.isEmpty()) {
      produtoPorPreco.addAll(produtoSet);
      return produtoPorPreco;
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public static void main(String[] args) {
    CadastroProtudos cadastroProdutos = new CadastroProtudos();

    // Adicionando produtos ao cadastro
    cadastroProdutos.cadastrarProduto(1L, "Smartphone", 1000d, 10);
    cadastroProdutos.cadastrarProduto(2L, "Notebook", 1500d, 5);
    cadastroProdutos.cadastrarProduto(1L, "Mouse", 30d, 20);
    cadastroProdutos.cadastrarProduto(4L, "Teclado", 50d, 15);

    //exibindo todos os produtos no cadastro
    System.out.println(cadastroProdutos.produtoSet);

    //exibindo produtos ordenados por nome
    System.out.println(cadastroProdutos.exibirProdutosPorNome());

    //exibindo produtos ordenados por preço
    System.out.println(cadastroProdutos.exibirProdutoPorPreco());
  }
}
