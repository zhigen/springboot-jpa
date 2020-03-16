package com.zglu.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zglu
 */
@Data
@NoArgsConstructor
public class UserRoleVo {
    private Long id;
    private String userName;
    private String roleName;

    public UserRoleVo(User u, UserRole ur) {
        this.id = u.getId();
        this.userName = u.getName();
        this.roleName = ur.getRoleId() + "";
    }
}
