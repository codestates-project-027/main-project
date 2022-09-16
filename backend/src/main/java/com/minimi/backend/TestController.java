package com.minimi.backend;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("get 성공", HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<String> post() {
        return new ResponseEntity<>("post 성공", HttpStatus.CREATED);
    }
    @PatchMapping("/patch")
    public ResponseEntity patch() {
        return new ResponseEntity<>(HttpStatus.RESET_CONTENT);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete() {
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
