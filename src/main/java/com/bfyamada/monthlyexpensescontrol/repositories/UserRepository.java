package com.bfyamada.monthlyexpensescontrol.repositories;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
