package br.com.map;

import java.util.NoSuchElementException;

public class ExceptionMap extends NoSuchElementException {
  public ExceptionMap(String message) {
    super(message);
  }
}
