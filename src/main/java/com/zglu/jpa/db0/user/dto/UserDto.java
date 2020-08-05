package com.zglu.jpa.db0.user.dto;

import com.zglu.jpa.db0.user.dao.User;
import com.zglu.jpa.db0.user.dao.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zglu
 */
@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String phone;

    public User toEntity() {
        User t = new User();
        t.setId(id);
        t.setName(name);
        return t;
    }

    public UserDto(User t) {
        id = t.getId();
        name = t.getName();
    }

    public UserDto(User t, UserInfo t1) {
        id = t.getId();
        name = t.getName();
        phone = t1.getPhone();
    }

}
