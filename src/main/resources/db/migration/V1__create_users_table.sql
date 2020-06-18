CREATE TABLE `users` (

	    `user_id`   int          NOT NULL AUTO_INCREMENT,
		`nickname`  varchar(255) NOT NULL,
		`email`     varchar(255) NOT NULL,
		`enabled`   boolean      NOT NULL DEFAULT true,
		`password`  varchar(255) NOT NULL DEFAULT 'aaa',
		`login_id`  varchar(255) NOT NULL,
    	`role`      varchar(32)  NOT NULL,
		`job`       varchar(32),
		PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;