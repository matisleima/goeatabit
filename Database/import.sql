INSERT INTO district (id, name)
VALUES (DEFAULT, 'Vanalinn'),
       (DEFAULT, 'Kesklinn'),
       (DEFAULT, 'Mustamäe'),
       (DEFAULT, 'Lasnamäe'),
       (DEFAULT, 'Pirita'),
       (DEFAULT, 'Kristiine'),
       (DEFAULT, 'Nõmme'),
       (DEFAULT, 'Õismäe'),
       (DEFAULT, 'Põhja-Tallinn');

INSERT INTO role (id, name)
VALUES (DEFAULT, 'admin'),
       (DEFAULT, 'customer');

INSERT INTO rating (id, level)
VALUES (DEFAULT, 1),
       (DEFAULT, 2),
       (DEFAULT, 3),
       (DEFAULT, 4),
       (DEFAULT, 5);

INSERT INTO location (id, address, district_id)
VALUES (DEFAULT, 'Aia 6', 1),
       (DEFAULT, 'Pargi 7', 2);

INSERT INTO "user" (id, first_name, last_name, password, status, role_id, image_id, location_id, e_mail)
VALUES (DEFAULT, 'Matis', 'Leima', '123', 'A', 1, null, 1, 'matisleima@gmail.com');

INSERT INTO offer (id, time, date, price, seats, name, description, food_group_id, status, user_id, rating_id)
VALUES (DEFAULT, )