package br.com.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GenericsExempleMap {
    public static void main(String[] args) {
//        Exemplo sem generics
        Map mapSemGenerics = new HashMap();
        mapSemGenerics.put(1, "PC");
        mapSemGenerics.put(2, "Condor");
        mapSemGenerics.put(3, "Laptop"); // Permite añadir cualquier tipo de valor.

//        Exemplo com generics
        Map<String, Integer> mapComGenerics = new TreeMap<>();
        mapComGenerics.put("chave 1", 10);
        mapComGenerics.put("Chave 2", 20);

//        Iterando sobre o map com generics
        for (Map.Entry entry : mapComGenerics.entrySet()) {
            String chave = (String) entry.getKey();
            Object valor = entry.getValue();
            System.out.println(STR."\{chave} \{valor}");
        }

//         Iterando sobre o mapa sem Generics (necessário fazer cast)
        for (Object obj : mapSemGenerics.entrySet()) {
//            Map.Entry entry = Map.entry(obj, mapSemGenerics.get(obj));
            Map.Entry entry = (Map.Entry) obj;
            Integer chave = (Integer) entry.getKey();
            Object valor = entry.getValue();
            System.out.println(STR."\{chave} \{valor}");
        }
    }
}

