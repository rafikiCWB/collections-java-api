package br.com.comparablexcomparator.generics;

public class Program  {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.setT(123);
        System.out.println(integerBox);
        Integer interValue = integerBox.getT();
        System.out.println(interValue);

    }

}
