package com.rejola.BProject.master.user;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/v1/master/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    private ResponseEntity<JsonNode> createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }


    @GetMapping
    private ResponseEntity<JsonNode> getUser() {
        return userService.getAllUser();
    }
   
    @DeleteMapping("/{id}")
    private ResponseEntity<JsonNode> delete(@PathVariable String id) {
        return userService.delete(id);
    }


}
