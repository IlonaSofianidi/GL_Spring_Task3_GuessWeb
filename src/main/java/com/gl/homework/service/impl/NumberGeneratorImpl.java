package com.gl.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();
    private GameProperties gameProperties;
    private int maxNumber;


    @Autowired
    public void setGameProperties(GameProperties gameProperties) {
        this.gameProperties = gameProperties;
    }

    @PostConstruct
    public void init() {
        maxNumber = gameProperties.getGameMaxNumber();
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}

