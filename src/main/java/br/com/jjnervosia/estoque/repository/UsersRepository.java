package br.com.jjnervosia.estoque.repository;

import br.com.jjnervosia.estoque.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT COUNT(u) FROM Users u")
    Long countUsers();
}
