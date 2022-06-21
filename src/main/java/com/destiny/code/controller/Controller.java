package com.destiny.code.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public abstract class Controller {
    private final ApplicationContext applicationContext;

    public Controller(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void loadPage(Resource pageResource, ActionEvent e) throws IOException {
        loadPage(pageResource, null, e);
    }

    public void loadPage(Resource pageResource, Resource cssResource, ActionEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(pageResource.getURL());
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        if (cssResource != null) {
            scene.getStylesheets().add(cssResource.getURL().toExternalForm());
        }
        PreviousPage.setParent(scene.getRoot());
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
    }
}
