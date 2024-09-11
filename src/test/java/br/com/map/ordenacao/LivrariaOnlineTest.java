package br.com.map.ordenacao;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LivrariaOnlineTest {

  @Test
  public void testExibirLivrosOrdenadosPorPreco() {
    LivrariaOnline livrariaOnline = new LivrariaOnline();

    livrariaOnline.adicionarLivro("link1", new Livro("Livro A", "Token", 30.0));
    livrariaOnline.adicionarLivro("link2", new Livro("Livro B", "Autor B", 20.0));
    livrariaOnline.adicionarLivro("link3", new Livro("Livro C", "Andrew", 10.0));
    livrariaOnline.adicionarLivro("link4", new Livro("Livro D", "Clarice", 5.0));

    Map<String, Livro> livrosOrdenados = livrariaOnline.exibirLivrosOrdenadosPorPreco();
    String[] expectedOrder = {"link4", "link3", "link2", "link1"};
    int i = 0;
    for (String key : livrosOrdenados.keySet()) {
      assertEquals(expectedOrder[i++], key);
    }
  }

  @Test
  public void testExibirLivrosOrdenadosPorAutor() {
    LivrariaOnline livrariaOnline = new LivrariaOnline();

    livrariaOnline.adicionarLivro("link1", new Livro("Livro A", "Token", 30.0));
    livrariaOnline.adicionarLivro("link2", new Livro("Livro B", "Clarice", 20.0));
    livrariaOnline.adicionarLivro("link3", new Livro("Livro C", "Andrew", 10.0));
    livrariaOnline.adicionarLivro("link4", new Livro("Livro D", "Autor D", 5.0));

    Map<String, Livro> livrosOrdenados = livrariaOnline.exibirLivrosOrdenadosPorAutor();

    String[] expectedOrder = {"Andrew", "Autor D", "Clarice", "Token"};
    int i = 0;
    for (Livro key : livrosOrdenados.values()) {
      assertEquals(expectedOrder[i++], key.getAutor());
    }

  }
}
