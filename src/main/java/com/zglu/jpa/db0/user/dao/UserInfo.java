package com.zglu.jpa.db0.user.dao;

import com.zglu.jpa.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author zglu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_info")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update user_info set deleted = 1 where id = ?")
public class UserInfo extends BaseEntity {
    private Long userId;
    private String phone;

}
