package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import main.Main;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("user") && password.equals("1234")) {
            System.out.println("Login sukses!");
        } else {
            System.out.println("Login gagal!");
        }
    }

    @FXML
    private void handleSingUpLink(ActionEvent event) {
        try {
            Parent registerPage = FXMLLoader.load(getClass().getResource("/view/Register.fxml"));
            Main.mainScene.setRoot(registerPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
