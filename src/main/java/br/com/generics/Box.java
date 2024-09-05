package br.com.generics;

import java.util.HashSet;
import java.util.Set;

// Lista genérica
public class Box<T> {

    private Set<T> genericSet;

    public Box() {
        this.genericSet = new HashSet<>();
    }

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Box{" +
                "genericSet=" + genericSet +
                ", t=" + t +
                '}';
    }
}

