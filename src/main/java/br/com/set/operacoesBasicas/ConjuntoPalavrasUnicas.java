package br.com.set.operacoesBasicas;

import br.com.set.ExceptionSet;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    //atributos
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        this.palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!this.palavrasUnicasSet.isEmpty()) {
            if (this.palavrasUnicasSet.contains(palavra)) {
                this.palavrasUnicasSet.remove(palavra);
            } else {
                throw new ExceptionSet("Palavra não encontrada no conjunto!");
            }
        } else {
            throw new ExceptionSet("O conjunto está vazio!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return this.palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavrasUnicasSet.isEmpty()) {
            System.out.println(palavrasUnicasSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Java");
        conjuntoPalavrasUnicas.adicionarPalavra("Java");
        conjuntoPalavrasUnicas.adicionarPalavra("Java script");
        conjuntoPalavrasUnicas.adicionarPalavra("Kotlin");

        //exibindo as palavras únicas no conjunto
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Java script");

        //removendo uma palavra inexistente do conjunto
//        conjuntoPalavrasUnicas.removerPalavra("PHP");

        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Java"));

    }

}
