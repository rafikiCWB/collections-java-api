package br.com.set.operacoesBasicas;

import java.util.Objects;

public record Convidado(String nome, int codigo) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return codigo == convidado.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
