package IFMG_LuizEduardo_RenatoZampiere.repository;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(nativeQuery = true, value = """
        SELECT price
            FROM
                public.rooms_table
            WHERE
                id = :id
    """)
    BigDecimal getRoomPriceById(Long id);


}
