package com.gl.homework.service.impl;

import com.gl.homework.entity.GameResult;
import com.gl.homework.exception.UserNotFoundException;
import com.gl.homework.repository.GameResultRepository;
import com.gl.homework.service.GameService;
import com.gl.homework.wire.GuessNumberResponse;
import com.gl.homework.wire.UserIdResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class GameServiceImpl implements GameService {
    private GameResultRepository gameResultRepository;
    private NumberGenerator numberGenerator;
    private int number;
    private int guess;

    @Autowired
    public void setGameResultRepository(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Autowired
    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @PostConstruct
    void reset() {
        guess = 0;
        number = numberGenerator.next();
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    private void setGuess(int guess) {
        this.guess = guess;
    }

    private boolean isGameWon() {
        return guess == number;
    }

    private GameResult findById(@NonNull Integer id) {
        return gameResultRepository.getResultById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public GuessNumberResponse getGameStatus(int user_id) {
        GameResult gameResult = findById(user_id);
        int user_number = gameResult.getNumber();
        setGuess(user_number);
        return GuessNumberResponse
                .builder()
                .status(isGameWon() ? "Win" : "Lose")
                .number(number)
                .userId(user_id)
                .userGuess(user_number)
                .build();

    }

    @Override
    public UserIdResponse saveUserGuess(int guess) {
        GameResult gameResult = new GameResult();
        gameResult.setNumber(guess);
        return UserIdResponse.builder()
                .userId(gameResultRepository.save(gameResult).getId())
                .number(guess)
                .build();

    }
}
