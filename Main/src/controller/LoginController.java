package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeCheckBox;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean remember = rememberMeCheckBox.isSelected();

        if (username.equals("user") && password.equals("1234")) {
            System.out.println("Login sukses!");
            if (remember) {
                System.out.println("User ingin diingat.");
            }
        } else {
            System.out.println("Login gagal!");
        }
    }
}
