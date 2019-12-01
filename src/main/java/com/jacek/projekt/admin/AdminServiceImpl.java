package com.jacek.projekt.admin;

import com.jacek.projekt.user.Role;
import com.jacek.projekt.user.RoleRepository;
import com.jacek.projekt.user.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("adminService")
@Transactional
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    private final AdminRepository adminRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userList = adminRepository.findAll(pageable);
        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = adminRepository.findUserById(id);
        return user;
    }

    @Override
    public void updateUser(int id, int nrRoli, int activity) {
        adminRepository.updateActivationUser(activity, id);
        adminRepository.updateRoleUser(nrRoli, id);
    }

    public void saveAll(List<User> userList) {
        for (int i = 0; i < userList.size(); i++) {
            Role role = roleRepository.findByRole("ROLE_USER");
            userList.get(i).setRoles(new HashSet<Role>(Arrays.asList(role)));
            userList.get(i).setPassword(bCryptPasswordEncoder.encode(userList.get(i).getPassword()));
        }
        adminRepository.saveAll(userList);
    }

    @Override
    public void deleteUserById(int id) {
        LOG.debug(" >>>>>>>>>>>>>>>> AdminServiceImpl.deleteUserById -> " + id);
        LOG.debug(" >>>>>>>>>>>>>>>> AdminRepository.deleteUserFromUserRole -> " + id);
        adminRepository.deleteUserFromUserRole(id);
        LOG.debug(" >>>>>>>>>>>>>>>> AdminRepository.deleteUserFromUser -> " + id);
        adminRepository.deleteUserFromUser(id);
    }

    @Override
    public Page<User> findAllSearch(String param, Pageable pageable) {
        Page<User> userList = adminRepository.findAllSearch(param, pageable);
        return userList;
    }
}