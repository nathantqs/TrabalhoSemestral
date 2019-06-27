package trabalho.model;

import java.util.ArrayList;

public class Pergunta {

    private String enunciado;
    private int correta;
    private ArrayList<String> opcoes;

    public Pergunta(String enunciado, int correta, ArrayList<String> opcoes) {
        this.enunciado = enunciado;
        this.correta = correta;
        this.opcoes = opcoes;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    public ArrayList<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "enunciado='" + enunciado + '\'' +
                ", correta=" + correta +
                ", opcoes=" + opcoes +
                '}';
    }
}
