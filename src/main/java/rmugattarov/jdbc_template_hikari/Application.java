package rmugattarov.jdbc_template_hikari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.printAll();
//        userRepository.persist();
    }
}
