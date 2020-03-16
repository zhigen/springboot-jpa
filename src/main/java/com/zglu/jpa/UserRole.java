package com.zglu.jpa;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zglu
 */
@Data
@Entity
@Table(name = "user_role")
@EntityListeners(AuditingEntityListener.class)
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long roleId;
    @CreatedDate
    private Date createdDate;
    @CreatedBy
    private Integer createdBy;
    @LastModifiedDate
    private Date modifiedDate;
    @LastModifiedBy
    private Integer modifiedBy;
    private boolean enable;
}
