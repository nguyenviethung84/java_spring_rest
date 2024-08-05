package vn.hoidanit.jobhunter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User postmanUser) {
        return this.userService.handlerCreateUser(postmanUser);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.handlerDeleteUser(id);
        return "delete user:" + Long.toString(id);
    }

    // fetch user by id
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") long id) {
        return this.userService.fetchUserById(id);
    }

    // fetch all users
    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.fetchAll();
    }

    // update user
    // @PutMapping("path/{id}")
    // public String putMethodName(@PathVariable String id, @RequestBody String
    // entity) {
    // //TODO: process PUT request

    // return entity;
    // }
    @PutMapping("/user")
    public User updateUser(@RequestBody User postmanUser) {
        return this.userService.handleUpdateUser(postmanUser);
    }

}
