package trabalho.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import trabalho.controller.JanelasAvisos;

import java.io.*;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Jogo  extends JanelasAvisos {


    private static String FILE="jogadores.bin";
    private static String FILE2="odeioirmaosneto.txt";

    private ObservableList<Jogador> jogadores;
    private ObservableList<Pergunta> perguntas;


    private Jogador logado;
    private int pontuacao;
    private int contPerguntas=0;
    private ArrayList<Integer> repetidos = new ArrayList<>();
    private int cont=0;


    private static Jogo instance = new Jogo();

    public Jogo(){
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();
    }

    public static Jogo getInstance(){
        return instance;
    }

    public void carregaJogadores() throws IOException, ClassNotFoundException{
        jogadores.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(FILE)
                )
        );

        ArrayList<Jogador> temp = (ArrayList)ois.readObject();

        jogadores.addAll(temp);
        ois.close();
        System.out.println(temp);

        System.out.println(jogadores);
    }

    public void addJogador(Jogador jogador){
        jogadores.add(jogador);
    }

    public void salvarJogadores() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(FILE))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();
    }

    public void  finalizaPartida() throws IOException{

        if(logado.getMaiorpontuacao() < pontuacao){
            logado.setMaiorpontuacao(pontuacao);
        }

        pontuacao = 0;
        salvarJogadores();

    }

    public Boolean buscaJogador(String nome){
        for(Jogador j: jogadores){
            if(j.getNome().equals(nome)){
                return true;
            }
        }

        return false;
    }

    public void marcaPontos(int verifica){
        if(verifica == 1){
            pontuacao = pontuacao+3;
            acerto();
        }
        else if(verifica == 2){
            pontuacao = pontuacao-1;
            erro();
        }
    }
    public Jogador getLogado() {
        return logado;
    }

    public void setLogado(Jogador logado) {
        this.logado = logado;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public ObservableList<Jogador> getJogador() {
        return FXCollections.observableArrayList(jogadores);
    }


    ///////////////////////////PERGUNTAS///////////////////////////////////
    public void carregaPerguntas(){
        String enunciado;
        int correta, quantperguntas, quantopcoes, sortear;


        try(FileReader file = new FileReader(FILE2);
            BufferedReader buff = new BufferedReader(file)){

            quantperguntas = Integer.valueOf(buff.readLine());
            quantopcoes= Integer.valueOf(buff.readLine());

            for(int i =0; i<quantperguntas;i++){
                ArrayList<String> opcoes = new ArrayList<>();
                enunciado = buff.readLine();

                for(int j = 0; j<quantopcoes; j++){
                    opcoes.add(buff.readLine());
                }

                correta = Integer.valueOf(buff.readLine());
                Pergunta p = new Pergunta(enunciado, correta, opcoes);
                perguntas.add(p);
            }



        }
        catch (IOException e){
            System.out.println(e);
        }

    }

    public boolean correta(int resposta){
        if (perguntas.get(cont).getCorreta() == resposta){
            return true;
        }
        return  false;

    }


    public ObservableList<Pergunta> getPerguntas() {
        return  perguntas;
    }

    public void setPerguntas(ObservableList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public ArrayList<Integer> getRepetidos() {
        return repetidos;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void setRepetidos(ArrayList<Integer> repetidos) {
        this.repetidos = repetidos;
    }

    public int getContPerguntas() {
        return contPerguntas;
    }

    public void setContPerguntas(int contPerguntas) {
        this.contPerguntas = contPerguntas;
    }

    public Pergunta setPerguntas(){
        Random rand = new Random();

        cont=rand.nextInt(perguntas.size());

        while ( repetidos.contains(cont)){
            cont=rand.nextInt(perguntas.size());
        }
        System.out.println(contPerguntas);
        contPerguntas+=1;

        repetidos.add(cont);

        if(contPerguntas < 5){
            return perguntas.get(cont);
        }
        return null;
    }
}
