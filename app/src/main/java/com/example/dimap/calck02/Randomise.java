package com.example.dimap.calck02;

import java.util.Random;

public class Randomise {
    private Random random = new Random();
    private int a;


    public int randomize() {
        a = random.nextInt(10) + 1;
        return a;
    }
}
