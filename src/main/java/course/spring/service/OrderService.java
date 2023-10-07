package course.spring.service;


import course.spring.entities.Order;
import course.spring.entities.User;
import course.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository OrderRepository;


    //get all Orders
    public List<Order> finAll(){
        return OrderRepository.findAll();
    }

    //get by id
    public Order findById(Long id){
        Optional<Order> obj = OrderRepository.findById(id);
        return obj.get();
    }

}
