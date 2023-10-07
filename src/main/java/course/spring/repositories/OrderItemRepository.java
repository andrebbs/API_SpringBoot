package course.spring.repositories;

import course.spring.entities.OrderItem;
import course.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
