package br.com.generics;

import java.util.HashSet;
import java.util.Set;

public class GenericsExempleSet {
    public static void main(String[] args) {
        Set conjuntoSemGenerics = new HashSet();
        conjuntoSemGenerics.add("NoGenerics pode ser texto ou numero ou classe");
        conjuntoSemGenerics.add(100);

        Set<String> conjuntoComGenerics = new HashSet<>();
        conjuntoComGenerics.add("Tem que ser String");
        conjuntoComGenerics.add("XPTO");
        conjuntoComGenerics.add("Joe Done");

        for (String elementosConjunto : conjuntoComGenerics) {
            System.out.println(elementosConjunto);
        }

        for (Object elementosDoConjunto : conjuntoSemGenerics) {
            Object str = elementosDoConjunto;
            System.out.println(str);
        }
    }
}
