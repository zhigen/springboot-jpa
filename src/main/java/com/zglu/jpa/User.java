package com.zglu.jpa;

import lombok.Data;

import javax.persistence.*;

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
}
