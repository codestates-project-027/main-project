package com.minimi.backend.facility.bookmark;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmark")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    //post bookmark
    @PostMapping("")
    public ResponseEntity postBookmark(@RequestBody BookmarkDto.request bookmarkReq){
        return new ResponseEntity(HttpStatus.CREATED);
    }
    //delete bookmark
    @DeleteMapping("/{facilityId}")
    public ResponseEntity deleteBookmark(@PathVariable Long facilityId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{username}")
    public ResponseEntity<BookmarkDto.response> getMyFacilitys(@PathVariable String username) {
        return new ResponseEntity<>(bookmarkService.getMyFacilitys(username), HttpStatus.OK);
    }

}
