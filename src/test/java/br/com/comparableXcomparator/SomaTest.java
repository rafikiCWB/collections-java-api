package br.com.comparableXcomparator;

import org.junit.jupiter.api.Test;

import br.com.comparablexcomparator.Soma;

import static org.junit.jupiter.api.Assertions.*;

class SomaTest {

    Soma soma = new Soma();

    @Test
    public void somar(){
        assertEquals(23, soma.somar(11,12));
    }
}