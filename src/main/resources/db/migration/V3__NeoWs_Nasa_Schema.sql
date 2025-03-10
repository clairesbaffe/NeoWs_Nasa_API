CREATE TABLE IF NOT EXISTS near_earth_objects (
    id INT NOT NULL AUTO_INCREMENT,
    neo_reference_id INT,
    name VARCHAR(100),
    name_limited VARCHAR(50),
    absolute_magnitude_h DOUBLE,
    estimated_diameter_min DOUBLE,
    estimated_diameter_max DOUBLE,
    is_potentially_hazardous_asteroid BOOLEAN,
    orbit_determination_date DATE,
    first_observation_date DATE,
    last_observation_date DATE,
    data_arc_in_days INT,
    observations_used INT,
    orbit_uncertainty VARCHAR(50),
    minimum_orbit_intersection DOUBLE,
    eccentricity DOUBLE,
    semi_major_axis DOUBLE,
    inclination DOUBLE,
    ascending_node_longitude DOUBLE,
    orbital_period DOUBLE,
    perihelion_distance DOUBLE,
    perihelion_argument DOUBLE,
    aphelion_distance DOUBLE,
    perihelion_time DOUBLE,
    mean_anomaly DOUBLE,
    mean_motion DOUBLE,
    equinox DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS relative_velocities(
    id INT NOT NULL AUTO_INCREMENT,
    kilometers_per_second DOUBLE,
    kilometers_per_hour DOUBLE,
    miles_per_hour DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS miss_distances(
    id INT NOT NULL AUTO_INCREMENT,
    astronomical DOUBLE,
    lunar DOUBLE,
    kilometers DOUBLE,
    miles DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS close_approaches(
    id INT NOT NULL AUTO_INCREMENT,
    approach_date DATE,
    orbiting_body VARCHAR(50),
    relative_velocity_id INT,
    miss_distance_id INT,
    neo_id INT,
    FOREIGN KEY (relative_velocity_id) REFERENCES relative_velocities(id),
    FOREIGN KEY (miss_distance_id) REFERENCES miss_distances(id),
    FOREIGN KEY (neo_id) REFERENCES near_earth_objects(id),
    PRIMARY KEY (id)
);