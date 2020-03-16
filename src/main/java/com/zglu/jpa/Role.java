package com.zglu.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * @author zglu
 */
@Data
@Entity
@Table(name = "role")
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {
        super();
    }
}
