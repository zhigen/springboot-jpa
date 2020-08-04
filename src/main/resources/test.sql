CREATE TABLE `user`
(
    `id`                 INT          NOT NULL AUTO_INCREMENT,
    `name`               VARCHAR(255) NOT NULL COMMENT 'id',
    `created_date`       datetime     NOT NULL COMMENT '创建时间',
    `created_by`         INT          NOT NULL COMMENT '创建人',
    `last_modified_date` datetime     NOT NULL COMMENT '最后更新时间',
    `last_modified_by`   INT          NOT NULL COMMENT '最后更新人',
    `deleted`            bit(1)       NOT NULL COMMENT '逻辑删除（1：是，0：否）',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户';