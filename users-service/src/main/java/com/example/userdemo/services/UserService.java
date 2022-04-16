package com.example.userdemo.services;

import com.example.userdemo.VO.Department;
import com.example.userdemo.VO.ResponseTemplateVO;
import com.example.userdemo.entities.User;
import com.example.userdemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    @SneakyThrows
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        try {
            ResponseEntity<Department> response = restTemplate.getForEntity(new URI("http://API-GATEWAY/departments/" + userId),
                    Department.class);

            vo.setUser(user);
            vo.setDepartment(response.getBody());
            return vo;
        } catch (RestClientException exception) { // this rest client exception processing will be done in the exception handler and completely removed from here. It will return an appropriate status
            if (((HttpServerErrorException.ServiceUnavailable) exception).getStatusCode().value() == 503) {
                log.error("Called GET DepartmentById from UserService but the DepartmentService is down.");
            }
            throw exception;
        }
    }
}
