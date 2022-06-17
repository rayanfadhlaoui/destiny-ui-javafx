package com.destiny.code.login;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    public UserDto login(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = new UserDto();
        userDto.setName(username);
        userDto.setPassword(password);
        HttpEntity<UserDto> userDtoHttpEntity = new HttpEntity<>(userDto);
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange(
                "http://localhost:8080/login",
                HttpMethod.GET,
                userDtoHttpEntity,
                UserDto.class);
        return responseEntity.getBody();
    }
}
