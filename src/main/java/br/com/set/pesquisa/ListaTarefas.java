package br.com.set.pesquisa;

import br.com.listas.operacoesbasicas.ListaDeTarefas;
import br.com.set.ExceptionSet;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ListaTarefas {
  Logger LOG = Logger.getLogger(ListaTarefas.class.getName());

  private Set<Tarefa> tarefasSet;

  public ListaTarefas() {
    this.tarefasSet = new HashSet<>();
  }

  public void adicionarTarefa(String descricao) {
    this.tarefasSet.add(new Tarefa(descricao));
  }

  public void removerTarefa(String descricao) {
    Tarefa tarefaParaRemover = null;
    if (!tarefasSet.isEmpty()) {
      for (Tarefa t : tarefasSet) {
        if (t.descricao().equalsIgnoreCase(descricao)) {
          tarefaParaRemover = t;
          break;
        }
      }
      tarefasSet.remove(tarefaParaRemover);
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
    if (tarefaParaRemover == null) {
      throw new ExceptionSet("Tarefa não encontrada!");
    }
  }

  public void exibirTarefas() {
    if (!tarefasSet.isEmpty()) {
      LOG.info(STR."\{tarefasSet}");
    } else {
      throw new ExceptionSet("Tarefa não encontrada!");
    }
  }

  public int contarTarefas() {
    return tarefasSet.size();
  }

  public Set<Tarefa> obterTarefasConcluidas() {
    Set<Tarefa> tarefasConcluidas = new HashSet<>();
    for (Tarefa t : tarefasSet) {
      if (t.isConcluida()) {
        tarefasConcluidas.add(t);
      }
    }
    return tarefasConcluidas;
  }

  public Set<Tarefa> obterTarefasPendentes() {
    Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
    for (Tarefa t : tarefasSet) {
      if (!t.isConcluida()) {
        tarefasNaoConcluidas.add(t);
      }
    }
    return tarefasNaoConcluidas;
  }

  public void marcarTarefaConcluida(String descricao) {
    Set<Tarefa> tarefasAtualizadas = new HashSet<>();
    for (Tarefa t : tarefasSet) {
      if (t.descricao().equalsIgnoreCase(descricao)) {
        tarefasAtualizadas.add(new Tarefa(t.descricao(), true));
      } else {
        tarefasAtualizadas.add(t);
      }
    }
    tarefasSet = tarefasAtualizadas;
  }

  public void marcarTarefaPendente(String descricao) {
    Tarefa tarefaParaMarcarComoPendente = null;
    for (Tarefa t : tarefasSet) {
      if (t.descricao().equalsIgnoreCase(descricao)) {
        tarefaParaMarcarComoPendente = t;
        break;
      }
    }
    Set<Tarefa> tarefaAtualizada = new HashSet<>();
    if (tarefaParaMarcarComoPendente != null) {
      if (tarefaParaMarcarComoPendente.concluida()) {
        tarefaAtualizada.add(new Tarefa(true));
      }
    } else {
      throw new ExceptionSet("Tarefa não encontrada na lista.");
    }
  }

  public void limparListaTarefas() {
    if (!tarefasSet.isEmpty()) {
      LOG.info("A lista já está vazia!");
    } else {
      tarefasSet.clear();
    }
  }

  public static void main(String[] args) {
    ListaTarefas listaTarefas = new ListaTarefas();

    listaTarefas.adicionarTarefa("Estudar java");
    listaTarefas.adicionarTarefa("Fazer exercícios físicos");
    listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
    listaTarefas.adicionarTarefa("Ler livro");
    listaTarefas.adicionarTarefa("Preparar apresentação");

    listaTarefas.exibirTarefas();

    listaTarefas.removerTarefa("fazer exercícios físicos");
    listaTarefas.exibirTarefas();

    System.out.println(listaTarefas.contarTarefas());

    System.out.println(listaTarefas.obterTarefasPendentes());

    listaTarefas.marcarTarefaConcluida("Ler Livro");
    listaTarefas.marcarTarefaConcluida("Estudar java");

    System.out.println(listaTarefas.obterTarefasConcluidas());

    listaTarefas.marcarTarefaPendente("Estudar Java");
    listaTarefas.exibirTarefas();

    listaTarefas.limparListaTarefas();
    listaTarefas.exibirTarefas();
  }
}
