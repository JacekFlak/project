package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {
    Page<User> findAll(Pageable pageable);
}
