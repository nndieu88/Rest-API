package com.smartosc.demo.controller;

import com.smartosc.demo.entiti.User;
import com.smartosc.demo.model.Dto.UserDto;
import com.smartosc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> listUser() {
        List<UserDto> userDtos = userService.listUserDto();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        UserDto userDto = userService.findUserDtoById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        return ResponseEntity.ok().body(user1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editUser(@PathVariable int id, @RequestBody User user) {
        UserDto userDto = userService.editUser(id, user);
        return ResponseEntity.ok().body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        List<UserDto> userDtos = userService.deleteUserById(id);
        return ResponseEntity.ok(userDtos);
    }
}
