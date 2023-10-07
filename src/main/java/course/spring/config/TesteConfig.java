package course.spring.config;

import course.spring.entities.*;
import course.spring.entities.enums.OrderStatus;
import course.spring.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {


        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum ", 90.5, "");
        Product p2 = new Product(null, "Smary TV", "Lorem ipsum ", 90.5, "");
        Product p3 = new Product(null, "Macbook Pro", "Lorem ipsum ", 90.5, "");
        Product p4 = new Product(null, "Rails for Dummies", "Lorem ipsum ", 90.5, "");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));


        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat1);
        p4.getCategories().add(cat1);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));

        User u1 = new User(null, "Maria", "maria@gmail.com", "987654321", "12345678");
        User u2 = new User(null, "joao", "joao@gmail.com", "987654321", "12345677");
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:00Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-05-20T09:53:00Z"), u2, OrderStatus.WAITTING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-04-20T10:53:00Z"), u1, OrderStatus.WAITTING_PAYMENT);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));


    }
}
