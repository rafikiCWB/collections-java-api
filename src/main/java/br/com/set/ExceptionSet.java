package br.com.set;

import java.util.NoSuchElementException;

public class ExceptionSet extends NoSuchElementException {
    public ExceptionSet(String message) {
        super(message);
    }
}
