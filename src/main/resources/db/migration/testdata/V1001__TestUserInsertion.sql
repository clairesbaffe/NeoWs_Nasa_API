INSERT INTO users (username, password, enabled) VALUES
('bouncer', '$2a$10$yJrK77Tkvibxcx2SvL5HFOqUbRbGG14SMJcL8jpCHCqafmGavFghi', true),
('scraper', '$2a$10$yJrK77Tkvibxcx2SvL5HFOqUbRbGG14SMJcL8jpCHCqafmGavFghi',  true),
('claire', '$2a$10$yJrK77Tkvibxcx2SvL5HFOqUbRbGG14SMJcL8jpCHCqafmGavFghi', true);


INSERT INTO users_roles (users_id, roles_id) VALUES
(1, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);

