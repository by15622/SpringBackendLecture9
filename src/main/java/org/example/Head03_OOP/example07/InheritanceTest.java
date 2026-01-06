package org.example.Head03_OOP.example07;

class User {
    protected String userId;
    protected String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void printUserInfo() {
        System.out.println("ID: " + userId + ", 이름: " + name);
    }
}

class PersonalUser extends User {
    private String email;

    public PersonalUser(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    @Override
    public void printUserInfo() {
        super.printUserInfo();
        System.out.println("이메일: " + email);
    }
}
//클래스 -> 객체  객체를 만들려면? 뭔가 필요해 -> 생성자(매서드)가 필요하다

//User 상속한 BusinessUser 클래스 생성
class BusinessUser extends User {
    private String email;
    //필드 추가
    private String companyName;

    public BusinessUser(String id, String name, String email, String companyName) {
        super(id, name);
        this.email = email;
        this.companyName = companyName;
    }

    //부모 메서드 변경 및 super 확인
    @Override
    public void printUserInfo() {
        super.printUserInfo();
        System.out.println("이메일: " + email);
        System.out.println("회사이름: " + companyName);
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        User u = new PersonalUser("U001", "Alice", "alice@example.com");
        u.printUserInfo();

        User b = new BusinessUser("U002", "Big show", "bigshow@gmail.com", "WWE");
        b.printUserInfo();
    }
}