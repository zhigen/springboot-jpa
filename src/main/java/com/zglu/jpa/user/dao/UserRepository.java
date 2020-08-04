package com.zglu.jpa.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zglu
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
