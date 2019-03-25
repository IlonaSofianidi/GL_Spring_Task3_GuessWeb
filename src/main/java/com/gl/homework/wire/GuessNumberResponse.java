package com.gl.homework.wire;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GuessNumberResponse implements Response {
    private final String status;
    private final int number;
    private final int userGuess;
    private final long userId;
}
