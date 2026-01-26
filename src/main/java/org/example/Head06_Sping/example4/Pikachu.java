package org.example.Head06_Sping.example4;

import org.springframework.stereotype.Component;

// Bean 이름 지정
@Component("pikachu")  // Bean 이름 명시
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("피카츄 100만 볼트!");
    }
}