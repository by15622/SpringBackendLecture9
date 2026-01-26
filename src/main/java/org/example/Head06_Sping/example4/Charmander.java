package org.example.Head06_Sping.example4;

import org.springframework.stereotype.Component;

@Component("charmander")
public class Charmander implements Pokemon {
    @Override
    public void attack() {
        System.out.println("파이리: 화염 방사!");
    }
}