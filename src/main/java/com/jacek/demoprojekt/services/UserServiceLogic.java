package com.jacek.demoprojekt.services;

import com.jacek.demoprojekt.modal.User;
import com.jacek.demoprojekt.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceLogic {

    private final UserRepository userRepository;

    public UserServiceLogic(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveMyUser(User user) {
        userRepository.save(user);
    }
}
