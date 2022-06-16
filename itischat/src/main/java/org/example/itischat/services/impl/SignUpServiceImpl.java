package org.example.itischat.services.impl;

import lombok.AllArgsConstructor;
import org.example.itischat.dto.UserDto;
import org.example.itischat.mapper.UserMapper;
import org.example.itischat.model.Role;
import org.example.itischat.model.State;
import org.example.itischat.model.User;
import org.example.itischat.repository.UserRepository;
import org.example.itischat.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void signUp(UserDto userDto) {
        User user = userMapper.getUser(userDto);
        user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
        user.setRole(Role.USER);
        user.setState(State.ACTIVE);
        userRepository.save(user);
    }
}
