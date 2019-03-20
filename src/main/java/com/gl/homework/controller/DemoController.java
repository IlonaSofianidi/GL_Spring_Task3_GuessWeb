package com.gl.homework.controller;

import com.gl.homework.service.impl.GameServiceImpl;
import com.gl.homework.wire.GuessNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class DemoController {
    private GameServiceImpl gameServiceImpl;

    @Autowired
    DemoController(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    @ResponseBody
    @GetMapping(value = "/{number}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<GuessNumberResponse> playGame(@PathVariable int number) {
        return ResponseEntity.ok()
                .body(gameServiceImpl.getGameStatus(number));
    }

}
