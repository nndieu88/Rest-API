package com.smartosc.demo.service;

import com.smartosc.demo.entiti.User;
import com.smartosc.demo.model.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<UserDto> listUserDto();

    public User findUserById(int id);

    public UserDto findUserDtoById(int id);

    public User createUser(User user);

    public UserDto editUser(int id, User user);

    public List<UserDto> deleteUserById(int id);
}
