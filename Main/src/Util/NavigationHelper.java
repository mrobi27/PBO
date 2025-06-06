package Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import main.Main;

import java.io.IOException;

public class NavigationHelper {

    public static void navigate(AnchorPane contentPane, String buttonId) {
        String fxmlFile;

        switch (buttonId) {
            case "homeBtn":
                fxmlFile = "/view/mahasiswa/DashboardMember.fxml";
                break;
            case "booksBtn":
                fxmlFile = "/view/mahasiswa/BookCatalogMember.fxml";
                break;
            case "borrowBtn":
                fxmlFile = "/view/mahasiswa/BorrowBook.fxml";
                break;
            case "historyBtn":
                fxmlFile = "/view/mahasiswa/History.fxml";
                break;
            case "logoutBtn":
                System.out.println("Logout dipanggil, load Login.fxml");
                try {
                    Parent loginRoot = FXMLLoader.load(NavigationHelper.class.getResource("/view/Login.fxml"));
                    Main.mainScene.setRoot(loginRoot);
                    Main.primaryStage.setTitle("Login - UMM Library Access");
                    Main.primaryStage.setMinWidth(900);
                    Main.primaryStage.setMinHeight(600);
                    System.out.println("Login.fxml berhasil di-load dan root scene diganti");
                } catch (IOException e) {
                    System.err.println("Failed to load Login.fxml during logout");
                    e.printStackTrace();
                }
                return;

            default:
                System.err.println("Unknown button id: " + buttonId);
                return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(NavigationHelper.class.getResource(fxmlFile));
            Parent newContent = loader.load();
            contentPane.getChildren().setAll(newContent);
            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);
        } catch (IOException e) {
            System.err.println("Failed to load FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}
