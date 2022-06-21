package com.destiny.launching;

import com.destiny.code.controller.Controller;
import com.destiny.code.login.LoginService;
import com.destiny.code.login.UserDto;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class LoadingController extends Controller {

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

    public LoadingController(LoginService loginService, ApplicationContext applicationContext) {
        super(applicationContext);
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
            loadPage(homePageResource, homeCssResource, e);
        } catch (IOException ioException) {
            throw new RuntimeException("loading page didnt work");
        }
    }
}
