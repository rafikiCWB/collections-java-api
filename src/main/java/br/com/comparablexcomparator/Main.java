package br.com.comparablexcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>() {
            {
                add(new Livro("Java - Guia do Programador: Atualizado Para Java 16", "Peter Jandl Junior", 2021));
                add(new Livro("Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java", "Raoul-Gabriel Urma e  Richard Warburton", 2021));
                add(new Livro("Microsserviços Prontos Para a Produção: Construindo Sistemas Padronizados em uma Organização de Engenharia de Software", "Susan J. Fowler", 2017));
                add(new Livro("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos", "Aditya Y. Bhargava", 2017));
                add(new Livro("Kotlin em Ação", "Dmitry Jemerov e Svetlana Isakova", 2017));
            }
        };

        System.out.println("Livros após a ordenação natural(título) ");
        Collections.sort(livros);
        for (Livro l : livros) {
            System.out.println(STR."\{l.titulo()} \{l.autor().toUpperCase()} \{l.ano()}");
        }

        System.out.println("==========================================");

        System.out.println("Livros apos a ordenação por ano");
        livros.sort(new CompararAno());
        for (Livro l : livros) {
            System.out.println(STR."\{l.ano()} \{l.titulo()} \{l.autor()}");
        }

        System.out.println("===========================================");

        System.out.println("Livros apos a ordenação por autor");
        Collections.sort(livros, new CompararAutor());
        for (Livro l : livros) {
            System.out.println(STR."\{l.autor()} \{l.titulo()} \{l.ano()}");
        }

        System.out.println("===========================================");

        System.out.println("Livros após a ordenação por ano, autor e título: ");
        Collections.sort(livros, new CompararAnoAutorTitulo());
        for (Livro l : livros) {
            System.out.println(STR."\{l.ano()} \{l.autor()} \{l.titulo()}");
        }
    }
}
