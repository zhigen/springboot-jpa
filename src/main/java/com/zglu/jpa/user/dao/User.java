package com.zglu.jpa.user.dao;

import com.zglu.jpa.user.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zglu
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private Long createdBy;
    private LocalDateTime lastModifiedDate;
    private Long lastModifiedBy;
    private Boolean enable;

    public static User valueOf(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        return user;
    }

}
