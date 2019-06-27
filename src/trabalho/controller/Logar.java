package trabalho.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import trabalho.main.Main;
import trabalho.model.Jogador;
import trabalho.model.Jogo;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Logar implements Initializable{
    @FXML
    private Button btLogar = new Button();
    @FXML
    private Button btSair = new Button();
    @FXML
    private TextField tfNome = new TextField();

    @FXML

    public void initialize(URL url, ResourceBundle rb) {


        btSair.setOnMouseClicked((MouseEvent e) ->{
            Main.fechar();
        });
    }

    public void acaologar(ActionEvent actionEvent) throws IOException {

            String nome = tfNome.getText();

            if (nome.length() > 0) {

                if (!Jogo.getInstance().buscaJogador(nome)) {

                    Jogador jogador = new Jogador(nome, 0, null);

                    Jogo.getInstance().addJogador(jogador);
                    Jogo.getInstance().salvarJogadores();

                    Main.trocaTela("principal");

                } else {
                    Main.trocaTela("principal");
                }

            } else {
                Jogo.getInstance().salvarJogadores();

                Main.trocaTela("logar");
            }
        }

}