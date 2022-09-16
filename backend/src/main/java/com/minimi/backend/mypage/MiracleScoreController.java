package com.minimi.backend.mypage;


import com.minimi.backend.mypage.domain.MiracleScoreDto;
import com.minimi.backend.mypage.service.MiracleScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miracleScore")
@RequiredArgsConstructor
public class MiracleScoreController {

    private final MiracleScoreService miracleScoreService;

    //get miracleScore
    @GetMapping("{username}")
    public ResponseEntity<MiracleScoreDto.response> getScore(@PathVariable String username){

        return new ResponseEntity<>(miracleScoreService.getScore(username), HttpStatus.OK);
    }
}
