package lomayd.DBMSLabLogging.api.domain.user.dto;

import lomayd.DBMSLabLogging.api.domain.user.User;

import lombok.*;

public class UserResponseDto {

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private String id;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private Integer age;

        public static UserInfo of(User user) {
            return UserInfo.builder()
                    .id(user.getId())
                    .password(user.getPassword())
                    .name(user.getName())
                    .nickname(user.getNickname())
                    .email(user.getEmail())
                    .age(user.getAge())
                    .build();
        }
    }
}