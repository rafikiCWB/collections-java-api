package br.com.set.pesquisa;

import br.com.set.ExceptionSet;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

public class AgendaContatos {

  private Set<Contato> contatoSet;

  public AgendaContatos() {
    this.contatoSet = new HashSet<>();
  }

  public void adicionarContato(String nome, int numero) {
    this.contatoSet.add(new Contato(nome, numero));
  }

  public void exibirContato() {
    if (!contatoSet.isEmpty()) {
      out.println(contatoSet);
    } else {
      out.println("O conjunto está vazio");
    }
  }

  public Set<Contato> pesquisarPorNome(String nome) {
    Set<Contato> contatosPorNome = new HashSet<>();
    if (!contatoSet.isEmpty()) {
      for (Contato c : contatoSet) {
        if (c.getNome().startsWith(nome)) {
          contatosPorNome.add(c);
          break;
        }
      }
      return contatosPorNome;
    } else {
      throw new ExceptionSet("O conjunto está vazio");
    }
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero) {


    for (Contato c : contatoSet) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        c.setNumero(novoNumero);
        return c;
      }
    }
    throw new ExceptionSet("Contato não encontrado");
  }

  public static void main(String[] args) {
    var agendaContatos = new AgendaContatos();

    agendaContatos.exibirContato();

    agendaContatos.adicionarContato("João", 123456789);
    agendaContatos.adicionarContato("Maria", 987654321);
    agendaContatos.adicionarContato("Maria Fernandes", 55555555);
    agendaContatos.adicionarContato("Ana", 88889999);
    agendaContatos.adicionarContato("Fernando", 77778888);
    agendaContatos.adicionarContato("Carolina", 55555555);

    agendaContatos.exibirContato();

    out.println(agendaContatos.pesquisarPorNome("Maria"));

    Contato newContato = agendaContatos.atualizarNumeroContato("João", 444455559);
    out.println(STR."Contato atualizado:\{newContato}");

    out.println("Contatos na agenda após atualização:");
    agendaContatos.exibirContato();
  }
}
