package com.pawfectbuddy.config.security;

import com.pawfectbuddy.model.entity.User;
import com.pawfectbuddy.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages user credentials. Upon new authentication request, it accesses UserRepository and looks for data which matches given username
 * @author Xenia Levit
 */

@Service
public class UserCredentialsSecurity implements UserDetailsService {

    @Autowired
    private UserRepositoryInterface userRepository;

    // find and return user by username, otherwise return null
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        // find all roles that user has (one user can have many roles)
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                    .collect(Collectors.toList());
            // return a SPRING SECURITY user object (not project entity user) !!!
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.isActive(),
                    true,
                    true,
                    true,
                    grantedAuthorities
            );
        }
        return null;
    }
}
