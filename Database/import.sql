INSERT INTO eat.role (id, name) VALUES (default, 'admin');
INSERT INTO eat.role (id, name) VALUES (default, 'user');
INSERT INTO eat.role (id, name) VALUES (default, 'moderator');

INSERT INTO eat.image (id, data, status) VALUES (default, 'imagedata', 'A');
INSERT INTO eat.image (id, data, status) VALUES (default, 'imagedata', 'A');
INSERT INTO eat.image (id, data, status) VALUES (default, 'imagetada', 'A');

INSERT INTO eat.district (id, name) VALUES (1, 'Vanalinn');
INSERT INTO eat.district (id, name) VALUES (2, 'Kesklinn');
INSERT INTO eat.district (id, name) VALUES (3, 'Mustamäe');
INSERT INTO eat.district (id, name) VALUES (4, 'Lasnamäe');
INSERT INTO eat.district (id, name) VALUES (5, 'Pirita');
INSERT INTO eat.district (id, name) VALUES (6, 'Kristiine');
INSERT INTO eat.district (id, name) VALUES (7, 'Nõmme');
INSERT INTO eat.district (id, name) VALUES (8, 'Õismäe');
INSERT INTO eat.district (id, name) VALUES (9, 'Põhja-Tallinn');

INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', '1', '123');
INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', '2', '123');
INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', '3', '123');

INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 1, 1, 'Peeter', 'Tamm');
INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 2, 2, 'Tarmo', 'Kask');
INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 3, 3, 'Laura', 'Pähkel');

INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 1, 'Aia tn 7', 1, null, null);
INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 2, 'Vabaduse väljak 1', 2, null, null);
INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 3, 'Sõpruse pst 2', 6, null, null);