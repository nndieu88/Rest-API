package com.smartosc.demo.service;

import com.smartosc.demo.entiti.User;
import com.smartosc.demo.mapper.UserMapper;
import com.smartosc.demo.model.Dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServicceImpl implements UserService {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "dieu", "dieu@gmail.com", "123456", "avatar1.img", "123"));
        users.add(new User(2, "trang", "trang@gmail.com", "123456", "avatar2.img", "123"));
        users.add(new User(3, "hoa", "hoa@gmail.com", "123456", "avatar3.img", "123"));
    }

    @Override
    public List<UserDto> listUserDto() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserMapper.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDto findUserDtoById(int id) {
        UserDto userDto = UserMapper.toUserDto(findUserById(id));
        return userDto;
    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public UserDto editUser(int id, User user) {
        User users=findUserById(id);
        users.setName(user.getName());
        users.setEmail(user.getEmail());
        users.setPhone(user.getPhone());
        users.setAvatar(user.getAvatar());
        return UserMapper.toUserDto(findUserById(id));
    }

    @Override
    public List<UserDto> deleteUserById(int id) {
        User user=findUserById(id);
        users.remove(user);
        return listUserDto();
    }
}
