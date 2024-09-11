package br.com.set.ordenacao;

import br.com.set.ExceptionSet;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class GerenciadorAlunos {
  Logger LOG = Logger.getLogger(GerenciadorAlunos.class.getName());

  public Set<Aluno> alunosSet;

  public GerenciadorAlunos() {
    this.alunosSet = new TreeSet<>();
  }

  public void adicionarAluno(String nome, Long matricula, Double nota) {
    alunosSet.add(new Aluno(nome, matricula, nota));
  }

  public void exibirAlunosPorNome() {
    Set<Aluno> alunosPorNome = new TreeSet<>(alunosSet);
    if (!alunosSet.isEmpty()) {
      alunosPorNome.addAll(alunosSet);
      LOG.info(STR."Alunos por nome \{alunosPorNome}");
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public void exibirAlunosPorNota() {
    Set<Aluno> alunosPorNota = new TreeSet<>(new CompararPorNota());
    if (!alunosSet.isEmpty()) {
      alunosPorNota.addAll(alunosSet);
      LOG.info(STR."Alunos por nota \{alunosPorNota}");
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public void removerAlunoPorMatricula(long matricula) {
    Aluno alunosParaRemover = null;
    if (!alunosSet.isEmpty()) {
      for (Aluno a : alunosSet) {
        if (a.matricula() == matricula) {
          alunosParaRemover = a;
          break;
        }
      }
      alunosSet.remove(alunosParaRemover);
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public static void main(String[] args) {
    GerenciadorAlunos ga = new GerenciadorAlunos();

    ga.adicionarAluno("João", 123456L, 7.5);
    ga.adicionarAluno("Maria", 123457L, 9.0);
    ga.adicionarAluno("Carlos", 123458L, 5.0);
    ga.adicionarAluno("Ana", 123459L, 6.8);

    //exibir todos os alunos no gerenciador
    System.out.println("Alunos no gerenciador");
    System.out.println(ga.alunosSet);

    //remover um alono com matrícula inválida e outro pelo número da matrícula
//    ga.removerAlunoPorMatricula(000L);
    ga.removerAlunoPorMatricula(123457L);
    System.out.println(ga.alunosSet);

    ga.exibirAlunosPorNome();

    ga.exibirAlunosPorNota();

  }
}
