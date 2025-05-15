package org.etjen.spring_sec.repository;

import org.etjen.spring_sec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
