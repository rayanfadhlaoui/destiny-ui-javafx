package com.destiny.code.login;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class LoginService {

    private UserDto currentUser;

    public Optional<UserDto> login(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = new UserDto();
        userDto.setName(username);
        userDto.setPassword(password);
        HttpEntity<UserDto> userDtoHttpEntity = new HttpEntity<>(userDto);
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange(
                "http://localhost:8080/users",
                HttpMethod.POST,
                userDtoHttpEntity,
                UserDto.class);
        UserDto currentUser = responseEntity.getBody();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            this.currentUser = currentUser;
        }
        return Optional.ofNullable(currentUser);
    }

    public UserDto getCurrentUser() {
        return currentUser;
    }
}
