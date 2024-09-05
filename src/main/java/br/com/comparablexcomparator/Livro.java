package br.com.comparablexcomparator;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public record Livro(String titulo, String autor, int ano) implements Comparable<Livro> {
    //    Usado para ordenar livros por ano
    @Override
    public int compareTo(@NotNull Livro o) {
        return titulo.compareTo(titulo);
    }
}

//Classe para comprar Livro por Autor
class CompararAutor implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        return l1.autor().compareToIgnoreCase(l2.autor());
    }
}

//classe para comparar Livro por Ano
class CompararAno implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        return Integer.compare(l1.ano(), l2.ano());
    }
}

class CompararAnoAutorTitulo implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        int ano = Integer.compare(l1.ano(), l2.ano());
        if (ano != 0)
            return ano;
        int autor = l1.autor().compareTo(l2.autor());
        if (autor != 0)
            return autor;
        return l1.titulo().compareTo(l2.titulo());
    }
}
