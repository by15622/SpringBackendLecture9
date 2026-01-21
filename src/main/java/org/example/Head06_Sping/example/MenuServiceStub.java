package org.example.Head06_Sping.example;

import java.util.List;

public class MenuServiceStub extends MenuService {

    public List<String> getMenuList() {
        return List.of("샘플커피1", "샘플커피2");
    }
}
