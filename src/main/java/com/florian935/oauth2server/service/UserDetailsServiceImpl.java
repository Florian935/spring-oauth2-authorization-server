package com.florian935.oauth2server.service;

import com.florian935.oauth2server.domain.AuthenticatedUser;
import com.florian935.oauth2server.domain.User;
import com.florian935.oauth2server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = userRepository.findByUserName(username);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("%s not found", username));
        }

        return new AuthenticatedUser(user);
    }
}
