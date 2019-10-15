package com.jacek.demoprojekt.user;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);
}
