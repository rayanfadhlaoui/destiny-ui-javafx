package com.destiny.launching;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/home/home_page.fxml")
    private Resource homePageResource;

    @Value("classpath:/home/home.css")
    private Resource homeCssResource;

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Parent parent = new FXMLLoader(homePageResource.getURL()).load();
            Stage stage = event.getStage();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(homeCssResource.getURL().toExternalForm());
            stage.setFullScreen(true);
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
