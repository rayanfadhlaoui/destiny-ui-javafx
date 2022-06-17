package com.destiny.launching;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class LoadingApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(DestinyUiApplication.class).run();
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        context.publishEvent(new StageReadyEvent(stage));
    }
}
