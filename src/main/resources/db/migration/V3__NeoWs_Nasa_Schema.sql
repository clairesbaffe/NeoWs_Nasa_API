CREATE TABLE IF NOT EXISTS near_earth_objects (
    id INT NOT NULL AUTO_INCREMENT,
    neo_reference_id INT,
    name VARCHAR(100),
    name_limited VARCHAR(50),
    absolute_magnitude_h DOUBLE,
    estimated_diameter_min DOUBLE,
    estimated_diameter_max DOUBLE,
    is_potentially_hazardous_asteroid BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS close_approaches(
    id INT NOT NULL AUTO_INCREMENT,
    approach_date DATE,
    kilometers_per_second DOUBLE,
    kilometers_miss_distance DOUBLE,
    orbiting_body VARCHAR(50),
    neo_id INT,
    FOREIGN KEY (neo_id) REFERENCES near_earth_objects(id),
    PRIMARY KEY (id)
);