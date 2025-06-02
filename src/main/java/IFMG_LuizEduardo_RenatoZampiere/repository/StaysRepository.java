package IFMG_LuizEduardo_RenatoZampiere.repository;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaysRepository extends JpaRepository <Stays, Long> {
}
