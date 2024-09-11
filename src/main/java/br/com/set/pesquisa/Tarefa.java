package br.com.set.pesquisa;

public record Tarefa(String descricao, boolean concluida) {

  public Tarefa(String descricao) {
    this(descricao, false);
  }

  public Tarefa(boolean concluida) {
    this("", concluida);
  }

  public boolean isConcluida() {
    return concluida;
  }
}
