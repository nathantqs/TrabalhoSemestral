package trabalho.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import trabalho.main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Principal implements Initializable{

    @FXML
    private Button btJogar = new Button();
    @FXML
    private Button btRanking = new Button();
    @FXML
    private Button btSair = new Button();


    public void initialize(URL url, ResourceBundle rb) {
        btJogar.setOnMouseClicked((MouseEvent e) -> {
            Main.trocaTela("jogar");
        });

        btRanking.setOnMouseClicked((MouseEvent e) -> {
            Main.trocaTela("ranking");
        });
        btSair.setOnMouseClicked((MouseEvent e) ->{
            Main.fechar();
        });
    }


}
