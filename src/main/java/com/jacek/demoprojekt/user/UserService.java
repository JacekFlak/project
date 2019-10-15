package com.jacek.demoprojekt.user;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);

}
