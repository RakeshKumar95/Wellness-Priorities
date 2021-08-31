create database demodb;
use demodb;

CREATE TABLE satisfaction_rating_m (
	rating_id INT NOT NULL, 
    name VARCHAR(256) NOT NULL,
    PRIMARY KEY (rating_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO satisfaction_rating_m VALUES 
(1, 'Worst'),
(2, 'Bad'),
(3, 'Okay'),
(4, 'Good'),
(5, 'Very Good');

CREATE TABLE categories_m (
	category_id INT NOT NULL, 
    name VARCHAR(256) NOT NULL,
    `description` VARCHAR(512) NOT NULL,
    is_active TINYINT NOT NULL DEFAULT 0,
    default_order INT NOT NULL UNIQUE,
    PRIMARY KEY (category_id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO categories_m VALUES
(1, 'Connection', 'Connection', 0, 1),
(2, 'Relationships', 'Connection', 0, 2),
(3, 'Career', 'Connection', 0, 3),
(4, 'Wealth', 'Connection', 0, 4);

CREATE TABLE user_satisfaction_t (
	id INT NOT NULL AUTO_INCREMENT, 
    user_id INT NOT NULL,
    category_id INT NOT NULL,
    rating_id INT NOT NULL,
	order_id INT NULL,
    is_deleted INT NOT NULL DEFAULT 0,
    created_time DATETIME NULL,
    last_updated_time DATETIME NULL,
    PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
