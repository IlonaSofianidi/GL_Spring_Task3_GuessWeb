package com.gl.homework.service.impl;

import com.gl.homework.service.GameService;
import com.gl.homework.wire.GuessNumberResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class GameServiceImpl implements GameService {
    private NumberGenerator numberGenerator;

    private int number;
    private int guess;

    @Autowired
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @PostConstruct
    @Override
    public void reset() {
        guess = 0;
        number = numberGenerator.next();
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }


    @Override
    public GuessNumberResponse getGameStatus(int guess) {
        setGuess(guess);
        return GuessNumberResponse
                .builder()
                .status(isGameWon() ? "Win" : "Lose")
                .build();

    }
}
