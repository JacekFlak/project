package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<User, Integer> {

}