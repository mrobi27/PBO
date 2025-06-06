package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;
    public static Scene mainScene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));

        mainScene = new Scene(root, 1280, 720); // Ukuran awal 1280x720 (minimize ukuran awal)
        primaryStage = stage;

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("UMM Library Access");

        primaryStage.setMinWidth(800);  // Minimal ukuran window agar tidak terlalu kecil
        primaryStage.setMinHeight(600);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
