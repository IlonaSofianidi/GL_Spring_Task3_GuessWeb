package com.gl.homework.service;

import com.gl.homework.wire.GuessNumberResponse;
import com.gl.homework.wire.UserIdResponse;

public interface GameService {

    UserIdResponse saveUserGuess(int guess);

    GuessNumberResponse getGameStatus(int guess);


}
