package lv.restart.your.love.Final.Project.Restart.Your.Love.repository;

import lv.restart.your.love.Final.Project.Restart.Your.Love.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This enables use of all the CRUD actions with database, etc
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
