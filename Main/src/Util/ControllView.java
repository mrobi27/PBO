package Util;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import main.Main;

import java.io.IOException;

public class ControllView {

    @FXML
    private Button homeBtn, booksBtn, borrowBtn, historyBtn, logoutBtn;

    @FXML
    private AnchorPane contentPane;  // ganti dari BorderPane

    @FXML
    private BorderPane rootPane; // tetap diperlukan untuk scene root

    @FXML
    public void initialize() {
        // Pasang handler navigasi ke semua tombol
        homeBtn.setOnAction(this::handleNavigation);
        booksBtn.setOnAction(this::handleNavigation);
        borrowBtn.setOnAction(this::handleNavigation);
        historyBtn.setOnAction(this::handleNavigation);
        logoutBtn.setOnAction(this::handleNavigation);

        // Tampilkan tampilan default (home/dashboard)
        NavigationHelper.navigate(contentPane, "homeBtn");
    }

    @FXML
    private void handleNavigation(ActionEvent event) {
        if (!(event.getSource() instanceof Button)) return;

        Button clickedBtn = (Button) event.getSource();
        String buttonId = clickedBtn.getId();

        if ("logoutBtn".equals(buttonId)) {
            showLogoutConfirmation(); // Ganti dari goToLogin()
        } else {
            NavigationHelper.navigate(contentPane, buttonId);
        }
    }

    private void showLogoutConfirmation() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Logout");
        alert.setHeaderText(null);
        alert.setContentText("Apakah Anda yakin ingin logout?");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                goToLogin();
            }
        });
    }

    private void goToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent loginRoot = loader.load();

            Scene loginScene = new Scene(loginRoot, 1200, 600);

            // Reset maximize agar tidak nge-bug
            Main.primaryStage.setMaximized(false);
            Main.primaryStage.setScene(loginScene);
            Main.primaryStage.setTitle("UMM Library Access");
            Main.primaryStage.setMinWidth(1200);
            Main.primaryStage.setMinHeight(600);

            // Delay sedikit sebelum setMaximized agar JavaFX bisa 'catch up'
            PauseTransition delay = new PauseTransition(Duration.millis(200));
            delay.setOnFinished(e -> Main.primaryStage.setMaximized(true));
            delay.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
