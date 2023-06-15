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
        User user = userService.joinUser(userJoin);
        log.info(null,
            append("type","INSERT"),
            append("id", user.getId()), 
            append("password", user.getPassword()),
            append("name", user.getPassword()),
            append("nickname", user.getPassword()),
            append("email", user.getPassword()),
            append("age", user.getAge()));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UserResponseDto.UserInfo> getUser(@RequestParam String id) {
        UserResponseDto.UserInfo userInfo = userService.getUser(id);
        log.info(null,
            append("type","READ"),
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
        User user = userService.modifyUser(id, userModify);
        log.info(null,
            append("type","UPDATE"),
            append("id", user.getId()), 
            append("password", user.getPassword()),
            append("name", user.getPassword()),
            append("nickname", user.getPassword()),
            append("email", user.getPassword()),
            append("age", user.getAge()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeUser(@RequestParam String id) {
        User user = userService.removeUser(id);
        log.info(null,
            append("type","DELETE"),
            append("id", user.getId()), 
            append("password", user.getPassword()),
            append("name", user.getPassword()),
            append("nickname", user.getPassword()),
            append("email", user.getPassword()),
            append("age", user.getAge()));
        return ResponseEntity.ok().build();
    }
}