package org.isamary.repository;

import org.isamary.entity.IUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<IUser, Long> {

    public Optional<IUser> findByEmail(String email);

    public Optional<IUser> findByUsernameOrEmail(String username, String email);

    public Optional<IUser> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

}
