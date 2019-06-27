package trabalho.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class JanelasAvisos {



    protected void fim(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"FIM DE JOGO :)");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void acerto(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"ACERTOU!!!!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void erro(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"ERROU!!!!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void pulos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"VOCÊ EXCEDEU O LIMITE DE PULOS");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }


}

