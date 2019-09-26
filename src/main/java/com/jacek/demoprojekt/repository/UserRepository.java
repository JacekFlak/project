package com.jacek.demoprojekt.repository;

import com.jacek.demoprojekt.modal.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
