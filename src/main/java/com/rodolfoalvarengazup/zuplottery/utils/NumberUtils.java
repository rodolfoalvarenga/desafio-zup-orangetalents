package com.rodolfoalvarengazup.zuplottery.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtils {
    public List<Integer> generateNumbers(){
        Random rand = new Random();
        List<Integer> numbers = new ArrayList<>();
        while ((long) numbers.size() < 6){
            int int_random = rand.nextInt(60);
            if(int_random != 0){
                numbers.add(int_random);
            }
        }

        return numbers;
    }
}
