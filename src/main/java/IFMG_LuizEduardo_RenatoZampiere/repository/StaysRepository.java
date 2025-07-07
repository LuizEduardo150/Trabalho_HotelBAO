package IFMG_LuizEduardo_RenatoZampiere.repository;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysUserDetailedDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;
import IFMG_LuizEduardo_RenatoZampiere.projections.StaysUserDetailedProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaysRepository extends JpaRepository <Stays, Long> {


    @Query(nativeQuery = true, value = """
        SELECT
            u.id AS userId,
            r.id AS roomId,
            r.name AS roomName,
            u.real_name AS clientName,
            u.phone AS clientPhone,
            u.email AS clientEmail,
            s.start_stay As startStay,
            s.end_stay AS endStay,
            s.total_cost AS totalCost
        FROM
            stays_table s
        JOIN
            user_table u ON s.user_id = u.id
        JOIN
            rooms_table r ON s.room_id = r.id
    """)
    public List<StaysUserDetailedProjection> getAllStaysDetailed();



    @Query(nativeQuery = true, value = """
        SELECT
            id, end_stay, start_stay, total_cost, room_id, user_id
        FROM\s
            public.stays_table
        WHERE
            room_id = :id
        ;
    """)
    public List<Stays> getStaysOfRoomById(Long id);



}
