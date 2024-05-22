package com.skyeye.skyeyeuserservice.api;

import com.skyeye.skyeyeuserservice.interceptor.BearerTokenWrapper;
import com.skyeye.skyeyeuserservice.model.Response;
import com.skyeye.skyeyeuserservice.model.UserDataRecord;
import com.skyeye.skyeyeuserservice.model.UserIdCardRecord;
import com.skyeye.skyeyeuserservice.service.UserDataService;
import com.skyeye.skyeyeuserservice.service.UserIdCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user-api")
public class UserController {
    final UserDataService userDataService;
    final UserIdCardService userIdCardService;
    final BearerTokenWrapper bearerTokenWrapper;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserDataRecord> getUserData() {
        //TODO add logic related to authorization and getting userId via provided access token
        return new Response<>(
            userDataService.getUserData(bearerTokenWrapper.getToken()),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDataRecord addUserData(
        @RequestBody @Valid UserDataRecord userDataRecord) {
        return userDataService.saveUser(userDataRecord);
    }

    @GetMapping(value = "/id-card", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<UserIdCardRecord> getUserIdCard() {
        //TODO add logic related to authorization and getting userId via provided access token
        return new Response<>(
            userIdCardService.getUserIdCardByUserid(bearerTokenWrapper.getToken()),
            HttpStatus.OK
        );
    }

    @PostMapping(value = "/id-card", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserIdCardRecord addUserIdCardData(
        @RequestBody @Valid UserIdCardRecord userIdCardRecord
    ) {
        //TODO add logic related to authorization and getting userId via provided access token
        return userIdCardService.saveIdCard(bearerTokenWrapper.getToken(), userIdCardRecord);
    }
}