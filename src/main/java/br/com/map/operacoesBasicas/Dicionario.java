package br.com.map.operacoesBasicas;

import br.com.map.ExceptionMap;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Dicionario {
  Logger LOG = Logger.getLogger(Dicionario.class.getName());

  private Map<String, String> dicionario;

  public Dicionario() {
    this.dicionario = new HashMap<>();
  }

  private void adicionarPalavra(String palavra, String definicao) {
    dicionario.put(palavra, definicao);
  }

  public void removerPalavra(String palavra) {
    if (!dicionario.isEmpty()) {
      dicionario.remove(palavra);
    } else {
      throw new ExceptionMap("O Dicionário está vazio");
    }
  }

  public String pesquisarPorPalavra(String palavra) {
    String definicao = dicionario.get(palavra);
    if (definicao != null) {
      return definicao;
    }
    throw new ExceptionMap("Linguagem não encontrada no dicionário");
  }

  public void exibirPalavra() {
    if (!dicionario.isEmpty()) {
      LOG.info(STR."\{dicionario}");
    } else {
      throw new ExceptionMap("O dicionário está vazio.");
    }

  }

  public static void main(String[] args) {
    Dicionario dicionario = new Dicionario();

    dicionario.adicionarPalavra("Java", "Linguagem de programação orientada a objetos");
    dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
    dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

    dicionario.exibirPalavra();

    String definicaoJava = dicionario.pesquisarPorPalavra("Java");
    System.out.println("Definiçaõ da linguagem Java: " + definicaoJava);

    dicionario.removerPalavra("typescript");
    dicionario.exibirPalavra();
  }
}
