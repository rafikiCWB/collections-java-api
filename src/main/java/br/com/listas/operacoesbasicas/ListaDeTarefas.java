package br.com.listas.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDeTarefas {
    private static final Logger LOG = Logger.getLogger(ListaDeTarefas.class.getName());
    ;

    private List<Tarefa> tarefaList;

    public ListaDeTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefaParaRemover = new ArrayList<>();
        if (!tarefaList.isEmpty()) {
            for (Tarefa t : tarefaList) {
                if (t.tarefa().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover.add(t);
                }
            }
            tarefaList.removeAll(tarefaParaRemover);
        } else {
            throw new ExceptionList("Lista está varia");
        }
    }

    public int obterNumeroTotalDeTarefas() {
        LOG.log(Level.INFO, "Número total de tarefas: {0}", tarefaList.size());
        return tarefaList.size();
    }

    public void obterDescricoesDeTarefas() {
        if (!tarefaList.isEmpty()) {
            System.out.println(tarefaList);
        } else {
            throw new ExceptionList("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        var listaDeTarefas = new ListaDeTarefas();

        // Mostra o tipo da lista, se é um ArrayList, LinkedList... etc
        String type = listaDeTarefas.tarefaList.getClass().getName();
        System.out.println(type);

        // usando o metodo classe para adicionar e mostrar a lista
        listaDeTarefas.adicionarTarefa("Primeira tarefa adicionada");
        listaDeTarefas.adicionarTarefa("Segunda tarefa adicionada");

        listaDeTarefas.obterDescricoesDeTarefas();
        System.out.println(STR."Você tem: \{listaDeTarefas.obterNumeroTotalDeTarefas()} tarefas");

        listaDeTarefas.removerTarefa("Primeira tarefa adicionada");

        listaDeTarefas.obterDescricoesDeTarefas();

        System.out.println(STR."Você tem: \{listaDeTarefas.obterNumeroTotalDeTarefas()} tarefas");
    }
}
