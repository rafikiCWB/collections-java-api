package br.com.generics;

import br.com.comparablexcomparator.Livro;

import java.util.ArrayList;
import java.util.List;

public class GenericsExempleList {
    public static void main(String[] args) {
//        Exemplo sem generics
        List listaSemGenerics = new ArrayList();
        listaSemGenerics.add("Name");
        listaSemGenerics.add(10); // Permite adicionar qualquer tipo de objeto
        listaSemGenerics.add(new Livro("Lord of the rings", "Token", 1950));
//        listaSemGenerics.forEach(System.out::println);

//        Iterando sobre a lista sem Generics (necessário fazer cast)
        for (Object elemento : listaSemGenerics) {
            String str = (String) elemento.toString();
            System.out.println(str);
        }

//        Exemplo com generics
        System.out.println("==============");
        List<Livro> listaComGenerics = new ArrayList<>();
        listaComGenerics.add(new Livro("Lord of the rings", "Token", 1950));
        listaComGenerics.add(new Livro("Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java", "Raoul-Gabriel Urma e  Richard Warburton", 2021));
//        listaComGenerics.forEach(System.out::println);

        for (Livro book : listaComGenerics) {
            System.out.println(book);
        }
    }
}
