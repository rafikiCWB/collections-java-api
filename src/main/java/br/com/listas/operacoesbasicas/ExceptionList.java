package br.com.listas.operacoesbasicas;

import java.util.NoSuchElementException;

public class ExceptionList extends NoSuchElementException {
    public ExceptionList(String message) {
        super(message);
    }
}
