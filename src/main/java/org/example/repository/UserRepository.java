package org.example.repository;

import org.example.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User getUserById(Long id);

    void create(User user);

    void delete(User user);

    void update(User user);

    List<User> findAllDesc();


}
