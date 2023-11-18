package com.flipkartclone.controllers;

import com.flipkartclone.entities.Users;
import com.flipkartclone.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @PostMapping
    public String getUserById(@RequestBody UserDto userDto) {
        Users user = new Users();
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        usersService.saveUser(user);
        return "user saved successfully";
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class UserDto {
    private String userName;
    private String password;
}

