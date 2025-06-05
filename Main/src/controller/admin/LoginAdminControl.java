package controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;

import java.io.IOException;

public class LoginAdminControl {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Admin login sukses!");
            try {
                Parent adminDashboard = FXMLLoader.load(getClass().getResource("/view/AdminDashboard.fxml"));
                Scene adminScene = new Scene(adminDashboard, 1200, 600);
                Main.primaryStage.setScene(adminScene);
                Main.primaryStage.setTitle("Admin Dashboard - UMM Library Access");
                Main.primaryStage.setMaximized(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Admin login gagal!");
            // Kamu bisa tambahkan Alert untuk user friendly
        }
    }

    @FXML
    private void handleMemberLoginLink(ActionEvent event) {
        try {
            Parent memberLoginPage = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene memberScene = new Scene(memberLoginPage, 1200, 600);
            Main.primaryStage.setScene(memberScene);
            Main.primaryStage.setTitle("User Login - UMM Library Access");
            Main.primaryStage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
