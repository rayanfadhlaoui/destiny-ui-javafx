package com.destiny.launching;

import com.destiny.code.login.LoginService;
import com.destiny.code.login.UserDto;
import com.destiny.old.PreviousPage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class Controller {

    @Value("classpath:/home/home.fxml")
    private Resource homePageResource;

    @Value("classpath:/home/home.css")
    private Resource homeCssResource;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Text errorMessage;

    private final LoginService loginService;

    public Controller(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login(ActionEvent e) {
        try {
            Optional<UserDto> user = loginService.login(username.getText(), password.getText());
            user.map(UserDto::getId)
                    .ifPresentOrElse(u -> loadHomePage(e), () -> errorMessage.setText("login or password incorrect"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void exit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }

    private void loadHomePage(ActionEvent e) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(homePageResource.getURL());
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = stage.getScene();
            scene.getStylesheets().add(homeCssResource.getURL().toExternalForm());
            PreviousPage.setParent(scene.getRoot());
            scene.setRoot(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ioException) {
            throw new RuntimeException("loading page didnt work");
        }
    }
}
