package br.com.listas.ordenacao;

import br.com.listas.operacoesbasicas.ExceptionList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {

    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, Double altura) {
        this.pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoaPorIdade = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()) {
            Collections.sort(pessoaPorIdade);
            return pessoaPorIdade;
        } else {
            throw new ExceptionList("A lista está vazia");
        }
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoaList);
        if (!pessoaList.isEmpty()) {
            Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
            return pessoaPorAltura;
        } else {
            throw new ExceptionList("A lista está vazia");
        }
    }

    public static void main(String[] args) {
//        Criando uma instância da classe Ordenação pessoa
        OrdenacaoPessoa op = new OrdenacaoPessoa();

        op.adicionarPessoa("Rafael Grando", 21, 1.69);
        op.adicionarPessoa("Jon Doe", 22, 1.59);
        op.adicionarPessoa("Joana doe", 18, 1.70);

        System.out.println(op.pessoaList);
        System.out.println(op.ordenarPorIdade());
        System.out.println(op.ordenarPorAltura());
    }
}
