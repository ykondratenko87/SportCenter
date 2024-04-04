package by.tms.sportcenter.repository;

import by.tms.sportcenter.entity.User;

import java.util.List;

public interface UserRepository {
    void add(User user);

    List<User> getAllUsers();

    void delete(User user);
}