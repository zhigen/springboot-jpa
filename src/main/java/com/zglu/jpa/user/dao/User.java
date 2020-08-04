package com.zglu.jpa.user.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zglu.jpa.common.BaseEntity;
import com.zglu.jpa.user.dto.UserDto;
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
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class User extends BaseEntity {
    private String name;

    public static User valueOf(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.name = dto.getName();
        return user;
    }

}
