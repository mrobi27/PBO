package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import main.Main;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleSingUpLink(ActionEvent event) {
        try {
            Parent registerPage = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
            Main.mainScene.setRoot(registerPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAdminLoginLink(ActionEvent event) {
        try {
            Parent adminLoginPage = FXMLLoader.load(getClass().getResource("/view/LoginAdmin.fxml"));
            Main.mainScene.setRoot(adminLoginPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (UserDatabase.isValidUser(username, password)) {
            System.out.println("Login sukses!");
            try {
                URL dashboardURL = getClass().getResource("/view/ViewControll.fxml");
                System.out.println("Dashboard.fxml URL: " + dashboardURL);

                if (dashboardURL == null) {
                    System.out.println("ERROR: Dashboard.fxml tidak ditemukan!");
                    return;
                }

                Parent dashboardRoot = FXMLLoader.load(dashboardURL);
                Scene dashboardScene = new Scene(dashboardRoot, 1200, 600); // Ukuran minimum

                Main.primaryStage.setScene(dashboardScene);
                Main.primaryStage.setTitle("Dashboard - UMM Library Access");
                Main.primaryStage.setMinWidth(1200);
                Main.primaryStage.setMinHeight(600);

// Reset fullscreen dan kembalikan
                Main.primaryStage.setMaximized(false);
                javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.millis(200));
                delay.setOnFinished(e -> Main.primaryStage.setMaximized(true));
                delay.play();


            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login gagal!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Gagal");
            alert.setHeaderText(null);
            alert.setContentText("Username atau password salah!");
            alert.showAndWait();
        }
    }
}
