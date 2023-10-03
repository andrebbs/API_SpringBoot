package course.spring.service;


import course.spring.entities.Product;
import course.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;


    //get all Products
    public List<Product> findAll(){
        return ProductRepository.findAll();
    }


    //get by id
    public Product findById(Long id){
        Optional<Product> obj = ProductRepository.findById(id);
        return obj.get();
    }
}
