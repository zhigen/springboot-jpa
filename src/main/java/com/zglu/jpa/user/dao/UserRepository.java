package com.zglu.jpa.user.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zglu
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    /**
     * U
     *
     * @param user 记录
     * @return 影响行数
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "UPDATE User SET " +
            "name = CASE WHEN :#{#user.name} IS NULL THEN name ELSE :#{#user.name} END, " +
            "createdDate = CASE WHEN :#{#user.createdDate} IS NULL THEN createdDate ELSE :#{#user.createdDate} END, " +
            "createdBy = CASE WHEN :#{#user.createdBy} IS NULL THEN createdBy ELSE :#{#user.createdBy} END, " +
            "lastModifiedDate = CASE WHEN :#{#user.lastModifiedDate} IS NULL THEN lastModifiedDate ELSE :#{#user.lastModifiedDate} END, " +
            "lastModifiedBy = CASE WHEN :#{#user.lastModifiedBy} IS NULL THEN lastModifiedBy ELSE :#{#user.lastModifiedBy} END, " +
            "enable = CASE WHEN :#{#user.enable} IS NULL THEN enable ELSE :#{#user.enable} END " +
            "WHERE id=:#{#user.id}")
    int update(@Param("user") User user);
}
