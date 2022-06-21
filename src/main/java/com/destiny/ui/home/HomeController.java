package com.destiny.ui.home;

import com.destiny.code.controller.Controller;
import com.destiny.code.login.LoginService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HomeController extends Controller {

    @Value("classpath:/home/newGame.fxml")
    private Resource newGamePageResource;

    private final LoginService loginService;

    public HomeController(LoginService loginService, ApplicationContext applicationContext) {
        super(applicationContext);
        this.loginService = loginService;
    }

    public void newGame(ActionEvent e) throws IOException {
        System.out.println(loginService.getCurrentUser().getId());
        loadPage(newGamePageResource, e);
    }

    public void exit(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }
}
