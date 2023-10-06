package course.spring.service;


import course.spring.entities.Category;
import course.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository CategoryRepository;


    //get all Categorys
    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }


    //get by id
    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }
}
