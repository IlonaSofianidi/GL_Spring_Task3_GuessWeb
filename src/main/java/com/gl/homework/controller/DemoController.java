package com.gl.homework.controller;

import com.gl.homework.service.impl.GameServiceImpl;
import com.gl.homework.wire.GuessNumberResponse;
import com.gl.homework.wire.UserIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
public class DemoController {
    private GameServiceImpl gameServiceImpl;


    @Autowired
    DemoController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @ResponseBody
    @PostMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserIdResponse> postNumber(@PathVariable int number) {
        return ResponseEntity.ok().body(gameServiceImpl.saveUserGuess(number));
    }

    @ResponseBody
    @GetMapping(value = "/{userId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GuessNumberResponse> getGameResults(@PathVariable @Min(value = 1, message = "User id should be higher") int userId) {
        return ResponseEntity.ok()
                .body(gameServiceImpl.getGameStatus(userId));
    }

}
