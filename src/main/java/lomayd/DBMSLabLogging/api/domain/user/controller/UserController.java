package lomayd.DBMSLabLogging.api.domain.user.controller;

import static net.logstash.logback.marker.Markers.append;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lomayd.DBMSLabLogging.api.domain.user.User;
import lomayd.DBMSLabLogging.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabLogging.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabLogging.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    
    private final UserService userService;
    
    @PostMapping
    public ResponseEntity<Void> joinUser(@RequestBody UserRequestDto.UserJoin userJoin) {
        log.info("REQUEST-INSERT: {\"id\": \"{}\", \"password\": \"{}\", \"name\": \"{}\", \"nickname\": \"{}\", \"email\": \"{}\", \"age\": {}}",
            userJoin.getId(), userJoin.getPassword(), userJoin.getName(), userJoin.getNickname(), userJoin.getEmail(), userJoin.getAge());
        log.info("",
            append("type", "REQUEST"),
            append("subtype", "INSERT"),
            append("id", userJoin.getId()), 
            append("password", userJoin.getPassword()),
            append("name", userJoin.getPassword()),
            append("nickname", userJoin.getPassword()),
            append("email", userJoin.getPassword()),
            append("age", userJoin.getAge()));
            
        userService.joinUser(userJoin);
            
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UserResponseDto.UserInfo> getUser(@RequestParam String id) {
        UserResponseDto.UserInfo userInfo = userService.getUser(id);
        
        log.info("RESPONSE-SELECT: {\"id\": \"{}\", \"password\": \"{}\", \"name\": \"{}\", \"nickname\": \"{}\", \"email\": \"{}\", \"age\": {}}",
            userInfo.getId(), userInfo.getPassword(), userInfo.getName(), userInfo.getNickname(), userInfo.getEmail(), userInfo.getAge());
        log.info("",
            append("type", "RESPONSE"),
            append("subtype", "SELECT"),
            append("id", userInfo.getId()), 
            append("password", userInfo.getPassword()),
            append("name", userInfo.getPassword()),
            append("nickname", userInfo.getPassword()),
            append("email", userInfo.getPassword()),
            append("age", userInfo.getAge()));
            
        return ResponseEntity.ok(userInfo);
    }

    @PatchMapping
    public ResponseEntity<Void> modifyUser(@RequestParam String id, @RequestBody UserRequestDto.UserModify userModify) {
        log.info("REQUEST-UPDATE: {\"id\": \"{}\", \"password\": \"{}\", \"name\": \"{}\", \"nickname\": \"{}\", \"email\": \"{}\", \"age\": {}}",
            id, userModify.getPassword(), userModify.getName(), userModify.getNickname(), userModify.getEmail(), userModify.getAge());
        log.info("",
            append("type", "REQUEST"),
            append("subtype", "UPDATE"),
            append("id", id), 
            append("password", userModify.getPassword()),
            append("name", userModify.getPassword()),
            append("nickname", userModify.getPassword()),
            append("email", userModify.getPassword()),
            append("age", userModify.getAge()));
            
        userService.modifyUser(id, userModify);
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeUser(@RequestParam String id) {
        User user = userService.removeUser(id);
        
        log.info("REQUEST-DELETE: {\"id\": \"{}\", \"password\": \"{}\", \"name\": \"{}\", \"nickname\": \"{}\", \"email\": \"{}\", \"age\": {}}",
            user.getId(), user.getPassword(), user.getName(), user.getNickname(), user.getEmail(), user.getAge());
        log.info("",
            append("type", "REQUEST"),
            append("subtype", "DELETE"),
            append("id", user.getId()), 
            append("password", user.getPassword()),
            append("name", user.getPassword()),
            append("nickname", user.getPassword()),
            append("email", user.getPassword()),
            append("age", user.getAge()));
            
        return ResponseEntity.ok().build();
    }
}