package lomayd.DBMSLabLogging.api.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.*;

@Document(indexName = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String password;
    private String name;
    private String nickname;
    private String email;
    private Integer age;
}