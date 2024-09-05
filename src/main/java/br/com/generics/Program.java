package br.com.generics;

import br.com.comparablexcomparator.Livro;

public class Program {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setT(123);
        System.out.println(integerBox);
        Integer interValue = integerBox.getT();
        System.out.println(interValue);

        System.out.println("=============");
        Box<Livro> box = new Box<>();
        System.out.println(box);
        box.setT(new Livro("Lord of the rings", "Token", 1950));
        System.out.println(box.getT());

        System.out.println("outro espaça na memoria");
        Box<Livro> otherBox = new Box<>();
        System.out.println(otherBox);
    }
}
