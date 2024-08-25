package br.com.comparablexcomparator.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//pesquisa lista: testando os métodos
public class CatalogoLivros {

    public static void main(String[] args) {

        var catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro(new Livro("Livro-1", "Autor-1", 2024));
        catalogoLivros.adicionarLivro("Livro-2", "Autor-2", 2025);
        System.out.println(catalogoLivros.livroList);

        System.out.println("================");
        System.out.println(catalogoLivros.pesquisarAutor("Autor-1"));

        System.out.println("==================");
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2024, 2024));

        System.out.println("===================");
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro-2"));

    }

    //atributo
    final List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livroList.add(livro);
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    private List<Livro> pesquisarAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.autor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
            return livrosPorAutor;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAno = new ArrayList<>();
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.anoPublicacao() >= anoInicial && l.anoPublicacao() <= anoFinal) {
                    livrosPorAno.add(l);
                }
            }
            return livrosPorAno;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livrosPorTitulo = null;
        if (!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.titulo().equalsIgnoreCase(titulo)) {
                    livrosPorTitulo = l;
                    break;
                }
            }
            return livrosPorTitulo;
        } else {
            throw new RuntimeException("Lista vazia");
        }
    }

}

