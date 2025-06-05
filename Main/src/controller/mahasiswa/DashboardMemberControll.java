package controller.mahasiswa;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import main.Main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DashboardMemberControll {

    @FXML
    private ListView<String> borrowedBooksList;

    @FXML
    private ListView<String> returnBook;

    @FXML
    public void initialize() {
        // Isi ListView dengan data awal
        List<String> borrowedBooks = Arrays.asList(
                "1. Laskar Pelangi - Andrea Hirata",
                "2. Bumi Manusia - Pramoedya Ananta Toer",
                "3. Filosofi Teras - Henry Manampiring"
        );
        borrowedBooksList.getItems().addAll(borrowedBooks);

        List<String> booksToReturn = Arrays.asList(
                "1. Atomic Habits - James Clear",
                "2. Rich Dad Poor Dad - Robert Kiyosaki"
        );
        returnBook.getItems().addAll(booksToReturn);
    }

    @FXML
    private void handleLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent loginPage = loader.load();

            Scene loginScene = new Scene(loginPage, 1200, 600);
            Main.primaryStage.setScene(loginScene);
            Main.primaryStage.setTitle("UMM Library Access");
            Main.primaryStage.setMinWidth(1200);
            Main.primaryStage.setMinHeight(600);

            // Optional: kembalikan ke fullscreen
            Main.primaryStage.setMaximized(false);
            javafx.animation.PauseTransition delay = new javafx.animation.PauseTransition(javafx.util.Duration.millis(200));
            delay.setOnFinished(e -> Main.primaryStage.setMaximized(true));
            delay.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
