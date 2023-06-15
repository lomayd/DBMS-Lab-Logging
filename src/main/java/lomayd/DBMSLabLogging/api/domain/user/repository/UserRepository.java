package lomayd.DBMSLabLogging.api.domain.user.repository;

import lomayd.DBMSLabLogging.api.domain.user.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<User, String> {

}