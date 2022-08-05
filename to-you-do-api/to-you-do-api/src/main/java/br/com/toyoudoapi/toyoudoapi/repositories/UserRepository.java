package br.com.toyoudoapi.toyoudoapi.repositories;

import br.com.toyoudoapi.toyoudoapi.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by igorcm3 on 03/08/2022 - 22:06
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
