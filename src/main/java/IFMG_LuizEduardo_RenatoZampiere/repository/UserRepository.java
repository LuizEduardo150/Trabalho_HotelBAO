package IFMG_LuizEduardo_RenatoZampiere.repository;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    public Optional<User> findByUserName(String userName);

}
