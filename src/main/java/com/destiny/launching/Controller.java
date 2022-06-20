package com.destiny.launching;

import com.destiny.code.login.LoginService;
import com.destiny.code.login.UserDto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Controller {

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
                    .ifPresentOrElse(System.out::println, () -> errorMessage.setText("login or password incorrect"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
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
