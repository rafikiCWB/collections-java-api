package br.com.set.operacoesBasicas;

import br.com.set.ExceptionSet;

import java.util.HashSet;
import java.util.Set;
//conjunto Set não permite elementos repetidos, e o TreeSet ordena os elementos em ordem natural, ou seja, ordem alfabética, crescente
public class ConjuntoConvidados {

    private Set<Convidado> convidadosSet;

    public ConjuntoConvidados() {
        this.convidadosSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigo) {
        this.convidadosSet.add(new Convidado(nome, codigo));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        if (!convidadosSet.isEmpty()) {
            for (Convidado c : convidadosSet) {
                if (c.codigo() == codigoConvite) {
                    convidadoParaRemover = c;
                    break;
                }
            }
            convidadosSet.remove(convidadoParaRemover);
        } else {
            throw new ExceptionSet("O conjunto está vazio");
        }
    }

    public int contarConvidados() {
        return this.convidadosSet.size();
    }

    public void exibirConvidados() {
        if (!convidadosSet.isEmpty()) {
            System.out.println(this.convidadosSet);
        } else {
            throw new ExceptionSet("O conjunto está vazio");
        }
    }


    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);

        conjuntoConvidados.exibirConvidados();

        System.out.println(STR."Existem: \{conjuntoConvidados.contarConvidados()}");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1235);

        System.out.println(STR."Existem: \{conjuntoConvidados.contarConvidados()} convidado(s) dentro do Set de convidados");


        conjuntoConvidados.exibirConvidados();
    }
}
