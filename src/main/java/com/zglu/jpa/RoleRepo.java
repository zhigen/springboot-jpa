package com.zglu.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zglu
 */
@Repository
public interface RoleRepo extends PagingAndSortingRepository<Role, Long> {

}
