package com.gl.homework.wire;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GuessNumberResponse implements Response {
    private final String status;
}
