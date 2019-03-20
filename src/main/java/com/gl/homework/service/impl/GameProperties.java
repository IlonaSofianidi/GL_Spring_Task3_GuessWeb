package com.gl.homework.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:game.properties")
@NoArgsConstructor
@Getter
@Setter
public class GameProperties {
    @Value("${game.maxNumber}")
    public int gameMaxNumber;
    @Value("${game.minNumber}")
    public int minNumber;
    @Value("${game.guessNumber}")
    public int guessNumber;

}


