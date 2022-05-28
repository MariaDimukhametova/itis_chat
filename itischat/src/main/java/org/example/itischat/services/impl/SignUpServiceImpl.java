package org.example.itischat.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.itischat.dto.UserDto;
import org.example.itischat.mapper.UserMapper;
import org.example.itischat.model.User;
import org.example.itischat.repository.UserRepository;
import org.example.itischat.services.SignUpService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public void signUp(UserDto userDto) {
        User user = userMapper.getUser(userDto);
        userRepository.save(user);
    }
}
