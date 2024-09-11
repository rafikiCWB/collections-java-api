package br.com.set.ordenacao;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public record Aluno(String nome, Long matricula, Double media) implements Comparable<Aluno> {
    @Override
    public int compareTo(@NotNull Aluno o) {
        return nome.compareTo(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno aluno)) return false;
      return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }
}

class CompararPorNota implements Comparator<Aluno> {

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Double.compare(o1.media(), o2.media());
    }
}
