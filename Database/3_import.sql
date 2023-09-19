INSERT INTO eat.role (id, name) VALUES (default, 'admin');
INSERT INTO eat.role (id, name) VALUES (default, 'user');
INSERT INTO eat.role (id, name) VALUES (default, 'moderator');

INSERT INTO eat.district (id, name) VALUES (1, 'Vanalinn');
INSERT INTO eat.district (id, name) VALUES (2, 'Kesklinn');
INSERT INTO eat.district (id, name) VALUES (3, 'Mustamäe');
INSERT INTO eat.district (id, name) VALUES (4, 'Lasnamäe');
INSERT INTO eat.district (id, name) VALUES (5, 'Pirita');
INSERT INTO eat.district (id, name) VALUES (6, 'Kristiine');
INSERT INTO eat.district (id, name) VALUES (7, 'Nõmme');
INSERT INTO eat.district (id, name) VALUES (8, 'Õismäe');
INSERT INTO eat.district (id, name) VALUES (9, 'Põhja-Tallinn');

INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'teele', '123');
INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'matis', '123');
INSERT INTO eat."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'nikolai', '123');

INSERT INTO eat.image (id, data, status) VALUES

INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 1, 1, 'Teele', 'Hõrandi');
INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 2, 2, 'Matis', 'Leima');
INSERT INTO eat.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 3, 3, 'Nikolai', 'Levitski');

INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 1, 'Aia tn 7', 1, null, null);
INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 2, 'Vabaduse väljak 1', 1, null, null);
INSERT INTO eat.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 3, 'Sõpruse pst 2', 1, null, null);

INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'supp');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'puder');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'praad');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'sushi');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'pasta');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'salat');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'magustoit');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'pagaritooted');
INSERT INTO eat.food_group (id, name) VALUES (DEFAULT, 'varia');

INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 1, 1, 9, '2023-09-22', 5.00, 2, 'Peedisupp', 'Ülimaitsev peedisupp, kus peeti polegi!', 1, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 1, 1, 10, '2023-09-23', 4.00, 17, 'Kartulipuder', 'Hea kartulipuder, ise tegin, tule sööma', 2, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 1, 1, 11, '2023-09-24', 3.00, 4, 'Kapsapraad', 'Koosneb ainult kapsast ja kapsast ja kapsastest...', 3, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 2, 2, 12, '2023-09-25', 6.00, 5, 'Soolasushi', 'Soola pole, küll on aga sushit, imehea, sa tahad seda!', 4, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 2, 2, 13, '2023-09-26', 70.00, 6, 'Pestopasta', 'Pasta italiano vanaisa retsepti järgi.', 5, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 2, 2, 14, '2023-09-27', 1.00, 10, 'Caesari salat', 'Caesar mõrvati 44 eKr ja selle salatiga pole tal midagi pistmist', 6, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 3, 3, 15, '2023-09-28', 8.00, 20, 'Tiramisu', 'Tiramisuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu', 7, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 3, 3, 16, '2023-09-29', 9.00, 30, 'Eilsed saiakesed', 'tegelt üleeilsed, aga ära räägi kellelegi', 8, 'A');
INSERT INTO eat.offer (id, user_id, location_id, time, date, price, total_portions, name, description, food_group_id, status) VALUES (DEFAULT, 3, 3, 17, '2023-09-30', 5.00, 7, 'Salapärane toit', 'Tule kohale, saad teada!', 9, 'A');
