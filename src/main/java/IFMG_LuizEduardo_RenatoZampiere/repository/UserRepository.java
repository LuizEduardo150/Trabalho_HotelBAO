package IFMG_LuizEduardo_RenatoZampiere.repository;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserBasicDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    public Optional<User> findByUserName(String userName);

    @Query(
            nativeQuery = true,
            value = "SELECT id, email, real_name, user_name, user_type FROM public.user_table;"
    )
    public Page<UserBasicDataDTO> getAllPaged(Pageable pageable);

    @Query(
        nativeQuery = true,
        value = """
                SELECT id, address, address_number, district, email, password, phone, real_name, registration_date, user_name, user_type
                    FROM public.user_table WHERE email = :email;
                """
    )
    public  Optional<User> getByEmail(String email);

    @Query(
        nativeQuery = true,
        value = """
                SELECT id, address, address_number, district, email, password, phone, real_name, registration_date, user_name, user_type
                    FROM public.user_table WHERE real_name = :name;
                """
    )
    public Optional<User> getByRealName(String name);



    @Query(
        nativeQuery = true,
        value = """
                SELECT id FROM public.user_table WHERE user_name = :userName;
                """
    )
    public Optional<Long> getUserIdByUserName(String userName);



}
