package com.zglu.jpa.db0.user.dao;

import com.zglu.jpa.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author zglu
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update user set deleted = 1 where id = ?")
public class User extends BaseEntity {
    private String name;

}
