INSERT INTO public.role (id, name) VALUES (default, 'admin');
INSERT INTO public.role (id, name) VALUES (default, 'user');
INSERT INTO public.role (id, name) VALUES (default, 'moderator');

INSERT INTO public.image (id, data, status) VALUES (default, 'imagedata', 'A');
INSERT INTO public.image (id, data, status) VALUES (default, 'imagedata', 'A');
INSERT INTO public.image (id, data, status) VALUES (default, 'imagetada', 'A');

INSERT INTO public.district (id, name) VALUES (1, 'Vanalinn');
INSERT INTO public.district (id, name) VALUES (2, 'Kesklinn');
INSERT INTO public.district (id, name) VALUES (3, 'Mustamäe');
INSERT INTO public.district (id, name) VALUES (4, 'Lasnamäe');
INSERT INTO public.district (id, name) VALUES (5, 'Pirita');
INSERT INTO public.district (id, name) VALUES (6, 'Kristiine');
INSERT INTO public.district (id, name) VALUES (7, 'Nõmme');
INSERT INTO public.district (id, name) VALUES (8, 'Õismäe');
INSERT INTO public.district (id, name) VALUES (9, 'Põhja-Tallinn');

INSERT INTO public."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'email1', '123');
INSERT INTO public."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'email2', '123');
INSERT INTO public."user" (id, role_id, rating, status, email, password) VALUES (default, 2, 1.0, 'A', 'email3', '123');

INSERT INTO public.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 1, 1, 'Peeter', 'Tamm');
INSERT INTO public.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 2, 2, 'Tarmo', 'Kask');
INSERT INTO public.contact (id, user_id, image_id, firstname, lastname) VALUES (default, 3, 3, 'Laura', 'Pähkel');

INSERT INTO public.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 1, 'Aia tn 7', 1, null, null);
INSERT INTO public.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 2, 'Vabaduse väljak 1', 2, null, null);
INSERT INTO public.location (id, user_id, address, district_id, longitude, latitude) VALUES (default, 3, 'Sõpruse pst 2', 6, null, null);