package org.example.Head06_Sping.example;

public class DIExampleUsingExtends {
    public static void main(String[] args) {

        MenuService service = new MenuService();
        MenuController controller = new MenuController(service);
        System.out.println("==실제 운영 예시==");
        controller.printMenu();

        MenuService stubService = new MenuServiceStub();
        MenuController testController = new MenuController(stubService);
        System.out.println("\n==테스트용 혹은 Stub 예시==");
        testController.printMenu();
    }
}