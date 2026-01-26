package org.example.Head06_Sping.example3;

public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
}