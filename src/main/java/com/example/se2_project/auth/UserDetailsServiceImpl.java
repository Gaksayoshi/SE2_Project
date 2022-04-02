package com.example.se2_project.auth;

import com.example.se2_project.model.User;
import com.example.se2_project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static com.example.se2_project.auth.PasswordEncoder.encodePassword;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // hard-coded admin account for testing, in real situation this should be created in database
        User uAdmin = new User();
        uAdmin.setId(1L);
        uAdmin.setUsername("admin");
        uAdmin.setPassword(encodePassword("matkhau"));
        uAdmin.setRole("ROLE_ADMIN");
        uAdmin.setEnabled(true);

//        User user = userRepo.getUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//        return new MyUserDetails(user);

        return new MyUserDetails(uAdmin);
    }
}
