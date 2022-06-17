package com.destiny.old;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public void newGame(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newgame/newGame.fxml"));
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        scene.getStylesheets().add(getClass().getResource("newgame/newGame.css").toExternalForm());
        PreviousPage.setParent(scene.getRoot());
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }
}
