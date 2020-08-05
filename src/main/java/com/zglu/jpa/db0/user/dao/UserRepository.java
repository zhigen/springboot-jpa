package com.zglu.jpa.db0.user.dao;

import com.zglu.jpa.db0.user.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zglu
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findBy();

    @Query("SELECT u FROM User u")
    List<User> hql();

    @Query(nativeQuery = true, value = "SELECT * FROM zglu0.user")
    List<User> sql();

    @Query("SELECT new com.zglu.jpa.db0.user.dto.UserDto(u) FROM User u")
    List<UserDto> hqlTo();

    @Query("SELECT new com.zglu.jpa.db0.user.dto.UserDto(u,ui) FROM User u JOIN UserInfo ui on u.id=ui.userId")
    List<UserDto> hqlJoinTo();

    @Query(nativeQuery = true, value = "SELECT * FROM zglu0.user")
    List<Map<String, Object>> sqlTo();

    @Query(nativeQuery = true, value = "SELECT u.*,u1.phone FROM zglu0.user u join zglu0.user_info u1 on u.id = u1.user_id")
    List<Map<String, Object>> sqlJoinTo(Pageable pageable);

}
