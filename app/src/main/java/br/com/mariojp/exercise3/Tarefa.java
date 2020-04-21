package br.com.mariojp.exercise3;

public class Tarefa {
    private String descricao;
    private int prioridade;

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {

        return descricao;
    }

    public int getPrioridade() {


        return prioridade;
    }

    // verificar se a descrição já existe
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tarefa)) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        return this.getDescricao().equals(other.getDescricao());
    }

    @Override
    public String toString() {

        return descricao + "  " + "Prioridade: " + prioridade;
    }

    @Override
    public int compareTo(Tarefa tarefa) {
        if (tarefa == null ) {
            return 0;
        }
        return prioridade.compareTo(tarefa.getPrioridade());
    }


}
