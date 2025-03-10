create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
create table close_approaches (kilometers_miss_distance float(53) not null, kilometers_per_second float(53) not null, approach_date datetime(6), id bigint not null auto_increment, neo_id bigint, orbiting_body varchar(255), primary key (id)) engine=InnoDB;
create table near_earth_objects (absolute_magnitude_h float(53), estimated_diameter_max float(53) not null, estimated_diameter_min float(53) not null, is_potentially_hazardous_asteroid bit not null, neo_reference_id integer not null, id bigint not null auto_increment, name varchar(255), name_limited varchar(255), primary key (id)) engine=InnoDB;
create table roles (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table users (enabled bit not null, id bigint not null auto_increment, token_expiration datetime(6), claim_token varchar(255), password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=InnoDB;
create table users_roles (roles_id bigint not null, users_id bigint not null) engine=InnoDB;
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username);
alter table close_approaches add constraint FKbtk6dgr7fuo5tr5q4tv6pavf4 foreign key (neo_id) references near_earth_objects (id);
alter table users_roles add constraint FKa62j07k5mhgifpp955h37ponj foreign key (roles_id) references roles (id);
alter table users_roles add constraint FKml90kef4w2jy7oxyqv742tsfc foreign key (users_id) references users (id);
