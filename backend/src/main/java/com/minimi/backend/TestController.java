package com.minimi.backend;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/get")
    public ResponseEntity get() {
        return new ResponseEntity("get 성공", HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity post(@RequestBody String string) {
        return new ResponseEntity("post 성공 data: "+string, HttpStatus.CREATED);
    }
    @PatchMapping("/patch")
    public ResponseEntity patch(@RequestBody String string) {
        return new ResponseEntity("patch 성공 data: "+string, HttpStatus.RESET_CONTENT);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete() {
        return new ResponseEntity("delete 성공", HttpStatus.NO_CONTENT);
    }
}
