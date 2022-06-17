package com.destiny.launching;

import com.destiny.code.login.LoginService;
import com.destiny.code.login.UserDto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class Controller {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

//    @Autowired
//    private LoginService loginService;

    public void login(ActionEvent e) throws IOException {
//        UserDto user = loginService.login(username.getText(), password.getText());
//        System.out.println(user.getId());
//        Parent root = FXMLLoader.load(getClass().getResource("newgame/newGame.fxml"));
//        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
//        Scene scene = stage.getScene();
//        scene.getStylesheets().add(getClass().getResource("newgame/newGame.css").toExternalForm());
//        PreviousPage.setParent(scene.getRoot());
//        scene.setRoot(root);
//        stage.setScene(scene);
//        stage.show();
    }

    public void exit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }
}
