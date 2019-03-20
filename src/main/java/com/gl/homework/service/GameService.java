package com.gl.homework.service;

import com.gl.homework.wire.GuessNumberResponse;

public interface GameService {
    void reset();

    void setGuess(int guess);

    boolean isGameWon();

    GuessNumberResponse getGameStatus(int guess);

}
