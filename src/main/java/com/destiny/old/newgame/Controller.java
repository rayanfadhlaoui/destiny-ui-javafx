package com.destiny.old.newgame;

import com.destiny.old.PreviousPage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void back(ActionEvent e) {
        root = PreviousPage.getRoot();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = stage.getScene();
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }
}
