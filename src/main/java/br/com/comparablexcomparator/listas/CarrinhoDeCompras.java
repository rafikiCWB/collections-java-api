package br.com.comparablexcomparator.listas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo
    private final List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    private void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public List<Item> removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
        return itemList;
    }

    private void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(this.itemList);
        } else {
            System.out.println("Lista vazia");
        }

    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    void main() {
        var coisas = new CarrinhoDeCompras();
        coisas.adicionarItem("Teclado", 249.49, 1);
        coisas.adicionarItem("Mouse", 249.50, 1);
        coisas.adicionarItem("Fone", 250, 1);

        coisas.exibirItens();

        System.out.println("===========");

        System.out.println(coisas.removerItem("mouse"));

        System.out.println("================");

        System.out.println(coisas.calcularValorTotal());



    }

}
