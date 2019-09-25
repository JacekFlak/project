package com.jacek.demoprojekt;

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
