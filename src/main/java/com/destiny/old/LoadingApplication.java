package com.destiny.old;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoadingApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loading.fxml"));
        stage.setTitle("Hello World");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("loading.css").toExternalForm());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
