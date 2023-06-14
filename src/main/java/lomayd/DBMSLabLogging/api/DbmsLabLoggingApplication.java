package lomayd.DBMSLabLogging.api;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DbmsLabLoggingApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DbmsLabLoggingApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		int i=0;
		while(true){
			Thread.sleep(1000);
			log.info("lomayd-logging-elk-{}", ++i);
		}
	}
}
