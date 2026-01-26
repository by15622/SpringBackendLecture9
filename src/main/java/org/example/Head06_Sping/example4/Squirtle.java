package org.example.Head06_Sping.example4;

import org.springframework.stereotype.Component;

@Component("squirtle")
public class Squirtle implements Pokemon {
    @Override
    public void attack() {
        System.out.println("꼬부기 거품광선!");
    }
}