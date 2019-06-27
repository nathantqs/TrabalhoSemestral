package trabalho.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import trabalho.main.Main;
import trabalho.model.Jogador;
import trabalho.model.Jogo;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Rank {

    @FXML
    private Button btSair = new Button();

    @FXML
    private ListView<Jogador> ltvRank;

    @FXML
    private Label lbJogada;

    public void initialize(){

       ltvRank.getItems().addAll(Jogo.getInstance().getJogador());
        System.out.println(ltvRank);
    }

    public void acaoSair(ActionEvent actionEvent) {

        Main.trocaTela("principal");

    }
}
