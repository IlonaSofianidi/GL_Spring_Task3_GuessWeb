package com.gl.homework.wire;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserIdResponse implements Response {
    private final long userId;
    private final int number;
}
