package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminService {

    Page<User> findAll(Pageable pageable);

    User findUserById(int id);

    void updateUser(int id, int nrRoli, int activity);

    void saveAll(List<User> userList);

    void deleteUserById(int id);

    Page<User> findAllSearch(String param, Pageable pageable);
}
