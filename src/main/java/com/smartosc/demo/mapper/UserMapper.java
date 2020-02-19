package com.smartosc.demo.mapper;

import com.smartosc.demo.entiti.User;
import com.smartosc.demo.model.Dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto userDto=new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setAvatar(user.getAvatar());

        return  userDto;
    }
}
