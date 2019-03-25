package com.gl.homework.wire;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class UserNotFoundResponse implements Response {
    private final String message;
    private final String url;
}
