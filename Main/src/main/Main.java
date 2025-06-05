package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage; // akses global stage
    public static Scene mainScene;    // akses global scene supaya bisa di-setRoot dari controller

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        mainScene = new Scene(root, 1200, 600);  // simpan scene di variabel static

        primaryStage = stage;
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("UMM Library Access");
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(600);
        primaryStage.setMaximized(true);

        primaryStage.show();
    }
}
