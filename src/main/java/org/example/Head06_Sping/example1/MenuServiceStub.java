package org.example.Head06_Sping.example1;

import java.util.List;

public class MenuServiceStub implements MenuService {
    @Override
    public List<String> getMenuList() {
        return List.of("샘플커피1", "샘플커피2");
    }
}