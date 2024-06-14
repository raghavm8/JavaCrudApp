package org.raghav.mycrudapp.Services;

import org.raghav.mycrudapp.Exceptions.UserNotFoundException;
import org.raghav.mycrudapp.Models.User;
import org.raghav.mycrudapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> AllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getUserById(UUID id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("No user found with ID: " + id);
    }

    public void deleteUser(UUID userId){
        userRepository.deleteById(userId);
    }
}
