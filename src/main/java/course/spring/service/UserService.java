package course.spring.service;


import course.spring.entities.User;
import course.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    //get all users
    public List<User> findAll(){
        return userRepository.findAll();
    }


    //get by id
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
