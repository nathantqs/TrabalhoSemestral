package trabalho.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Jogador implements Serializable {

    private String nome;
    private int maiorpontuacao;
    private Date ultimaJogada;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public Jogador(String nome, int maiorpontuacao, Date ultimaJogada){
        this.nome = nome;
        this.maiorpontuacao = maiorpontuacao;
        this.ultimaJogada = ultimaJogada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaiorpontuacao() {
        return maiorpontuacao;
    }

    public void setMaiorpontuacao(int maiorpontuacao) {
        this.maiorpontuacao = maiorpontuacao;
    }

    public Date getUltimaJogada() {
        return ultimaJogada;
    }

    public void setUltimaJogada(Date ultimaJogada) {
        this.ultimaJogada = ultimaJogada;
    }



    @Override
    public String toString() {
        String str="";

        str+=nome+"   "+maiorpontuacao;

        return  str;
    }
}
