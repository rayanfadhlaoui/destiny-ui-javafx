package com.destiny;

import com.destiny.launching.LoadingApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DestinyUiApplication {

    public static void main(String[] args) {
        Application.launch(LoadingApplication.class, args);
    }

}
