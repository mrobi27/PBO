package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import main.Main;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleSignUpLink(ActionEvent event) {
        try {
            Parent registerPage = FXMLLoader.load(getClass().getResource("/view/mahasiswa/Register.fxml"));
            Main.mainScene.setRoot(registerPage);
            Main.primaryStage.setTitle("Register - UMM Library Access");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAdminLoginLink(ActionEvent event) {
        try {
            Parent adminLoginPage = FXMLLoader.load(getClass().getResource("/view/admin/LoginAdmin.fxml"));
            Main.mainScene.setRoot(adminLoginPage);
            Main.primaryStage.setTitle("Admin Login - UMM Library Access");
            Main.primaryStage.setMinWidth(900);
            Main.primaryStage.setMinHeight(600);
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
                URL dashboardURL = getClass().getResource("/view/mahasiswa/ViewControll.fxml");
                if (dashboardURL == null) {
                    System.out.println("ERROR: ViewControll.fxml tidak ditemukan!");
                    return;
                }
                Parent dashboardRoot = FXMLLoader.load(dashboardURL);
                Main.mainScene.setRoot(dashboardRoot);
                Main.primaryStage.setTitle("Dashboard - UMM Library Access");
                Main.primaryStage.setMinWidth(1200);
                Main.primaryStage.setMinHeight(600);
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
