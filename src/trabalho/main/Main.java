package trabalho.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import trabalho.model.Jogo;

import java.util.ArrayList;

public class Main extends Application {

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    private static Stage stage;
    private static Scene loginScene;
    private static Scene principalScene;
    private static Scene rankingScene;
    private static Scene jogarScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Quiz ziqueira!");

        Jogo.getInstance().carregaJogadores();


        Parent loginFXML = FXMLLoader.load(getClass().getResource("/trabalho/view/Login.fxml"));
        loginScene = new Scene(loginFXML, 510, 300);

        Parent principalFXML = FXMLLoader.load(getClass().getResource("/trabalho/view/Principal.fxml"));
        principalScene = new Scene(principalFXML, 570, 300);

        Parent rankFXML = FXMLLoader.load(getClass().getResource("/trabalho/view/Rank.fxml"));
        rankingScene = new Scene(rankFXML, 570, 330);

        Parent jogoFXML = FXMLLoader.load(getClass().getResource("/trabalho/view/Jogo.fxml"));
        jogarScene = new Scene(jogoFXML, 550, 360);


        primaryStage.setScene(loginScene);
        primaryStage.show();

    }

    public static void trocaTela(String scr){

        switch (scr){
            case "principal":
                stage.setScene(principalScene);
                notifyAllListeners("principal");
                break;

            case "ranking":
                stage.setScene(rankingScene);
                notifyAllListeners("ranking");
                break;

            case "jogar":
                stage.setScene(jogarScene);
                notifyAllListeners("jogar");
                break;
            case "logar":
                stage.setScene(loginScene);
                notifyAllListeners("logar");
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    //--------------------------------------------------------------------



    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen){
        for(OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen);
        }
    }



    public static void fechar(){
        stage.close();
    }
}