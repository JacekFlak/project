package com.jacek.projekt.admin;

import com.jacek.projekt.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminService")
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userList = adminRepository.findAll(pageable);
        return userList;
    }

}