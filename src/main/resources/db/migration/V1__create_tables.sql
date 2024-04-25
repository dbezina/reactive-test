CREATE TABLE IF NOT EXISTS taco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
-- Error Code: 1064. You have an error in your SQL syntax; book_genrebook_genrecheck the manual that corresponds to your MySQL server version for the right syntax to use near 'WRAP,                        PROTEIN,                        VEGGIES,           ' at line 5


CREATE TABLE IF NOT EXISTS ingredient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    food_type VARCHAR(25) NOT NULL
);

CREATE TABLE taco_ingredients (
    taco_id BIGINT,
    ingredient_id BIGINT,
    FOREIGN KEY (taco_id) REFERENCES taco(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id),
    PRIMARY KEY (taco_id, ingredient_id)
);

CREATE TABLE taco_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    taco_id BIGINT,
--    user_id BIGINT,
    delivery_name VARCHAR(255) not null,
    delivery_address VARCHAR(255) not null,
    delivery_city VARCHAR(255) not null,
    delivery_state VARCHAR(255) not null,
    cc_number VARCHAR(20) not null,
    cc_cvv VARCHAR(20) not null,
    cc_expiration VARCHAR(20) not null,
    FOREIGN KEY (taco_id) REFERENCES taco(id)
   -- FOREIGN KEY (user_id) REFERENCES user(id)
);