package course.spring.config;

import course.spring.entities.Order;
import course.spring.entities.User;
import course.spring.repositories.OrderRepository;
import course.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "987654321", "12345678");
        User u2 = new User(null, "joao", "joao@gmail.com", "987654321", "12345677");

        Order a1 = new Order(null, Instant.parse("2019-06-20T19:53:00Z"), u1);
        Order a2 = new Order(null, Instant.parse("2019-05-20T09:53:00Z"), u2);
        Order a3 = new Order(null, Instant.parse("2019-04-20T10:53:00Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(a1, a2, a3));
    }
}
