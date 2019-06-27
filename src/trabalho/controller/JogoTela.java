package trabalho.controller;

import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import trabalho.main.Main;
import trabalho.model.Jogo;
import trabalho.model.Pergunta;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JogoTela  extends JanelasAvisos {




    @FXML
    private RadioButton rbOp1;

    @FXML
    private RadioButton rbOp2;

    @FXML
    private RadioButton rbOp3;

    @FXML
    private RadioButton rbOp4;

    @FXML
    private Label lbPerguntas;

    private ObservableList<Pergunta> perguntas = Jogo.getInstance().getPerguntas();
    int cont = 0, respondidas = 0, pulos = 3;


    public void initialize(){

        try{
            Jogo.getInstance().carregaPerguntas();

        }catch(Exception e){
            e.printStackTrace();
        }

        tela(Jogo.getInstance().setPerguntas());

    }

    private void tela(Pergunta p) {

        lbPerguntas.setText(p.getEnunciado());
        rbOp1.setText(p.getOpcoes().get(0));
        rbOp2.setText(p.getOpcoes().get(1));
        rbOp3.setText(p.getOpcoes().get(2));
        rbOp4.setText(p.getOpcoes().get(3));
    }


    public int selecionar() {
        if (rbOp1.isSelected()) {
            return 1;
        } else if (rbOp2.isSelected()) {
            return 2;
        } else if (rbOp3.isSelected()) {
            return 3;
        } else {
            return 4;
        }
    }

    public void concluido(javafx.event.ActionEvent actionEvent) throws IOException {

        if(rbOp1.isSelected() || rbOp2.isSelected() || rbOp3.isSelected() || rbOp4.isSelected()) {

            if (Jogo.getInstance().correta(selecionar())) {
                Jogo.getInstance().marcaPontos(1);

            } else {
                Jogo.getInstance().marcaPontos(2);
            }

            if (Jogo.getInstance().getContPerguntas() != 5) {
                rbOp1.setSelected(false);
                rbOp2.setSelected(false);
                rbOp3.setSelected(false);
                rbOp4.setSelected(false);
                tela(Jogo.getInstance().setPerguntas());
            }

            else {
                System.out.println("aaaaaaa");
                Jogo.getInstance().finalizaPartida();
                fim();
                Main.trocaTela("principal");
            }
        }


    }

    public void desistir(javafx.event.ActionEvent actionEvent) {
        Main.trocaTela("principal");
    }

    public void pular(javafx.event.ActionEvent actionEvent) {
        if (pulos > 0) {
            pulos--;
            cont++;
            tela(Jogo.getInstance().setPerguntas());
        } else {
            pulos();
        }

    }
}