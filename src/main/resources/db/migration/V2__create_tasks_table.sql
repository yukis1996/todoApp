CREATE TABLE `tasks` (

	    `task_id`    int          NOT NULL AUTO_INCREMENT,
		`task_name`  varchar(255) NOT NULL,
		`day`        date         NOT NULL,
		`prioritize` int          NOT NULL DEFAULT 1,
		`status`     int          NOT NULL DEFAULT 1,
		`memo`       LONGTEXT,
		`user_id`    int          NOT NULL ,
		PRIMARY KEY (`task_id`),
		FOREIGN KEY (`user_id`)   REFERENCES `users` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;