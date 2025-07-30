--users
INSERT INTO users (user_id, password, username, user_email, active) VALUES (1, '$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'panda', 'panda@gmail.com', true);
INSERT INTO users (user_id, password, username, user_email, active) VALUES (2, '$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'not_admin', 'notadmin@gmail.com', true);
--routes
INSERT INTO routes (route_id, route_url) VALUES (1, '/index.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (2, '/403.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (3, '/404.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (4, '/charity.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (5, '/login.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (6, '/profile.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (7, '/registration.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (8, '/admin/adashboard.xhtml');
INSERT INTO routes (route_id, route_url) VALUES (9, '/adoption.xhtml');
--roles
INSERT INTO roles (role_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (role_id, role_name) VALUES (2, 'ROLE_USER');
INSERT INTO roles (role_id, role_name) VALUES (3, 'ROLE_GUEST');
--mapping of routes and roles
INSERT INTO route_role (route_id, role_id) VALUES (1, 1);
INSERT INTO route_role (route_id, role_id) VALUES (2, 1);
INSERT INTO route_role (route_id, role_id) VALUES (3, 1);
INSERT INTO route_role (route_id, role_id) VALUES (4, 1);
INSERT INTO route_role (route_id, role_id) VALUES (5, 1);
INSERT INTO route_role (route_id, role_id) VALUES (6, 1);
INSERT INTO route_role (route_id, role_id) VALUES (7, 1);
INSERT INTO route_role (route_id, role_id) VALUES (8, 1);
INSERT INTO route_role (route_id, role_id) VALUES (9, 1);
INSERT INTO route_role (route_id, role_id) VALUES (1, 2);
INSERT INTO route_role (route_id, role_id) VALUES (2, 2);
INSERT INTO route_role (route_id, role_id) VALUES (3, 2);
INSERT INTO route_role (route_id, role_id) VALUES (4, 2);
INSERT INTO route_role (route_id, role_id) VALUES (5, 2);
INSERT INTO route_role (route_id, role_id) VALUES (6, 2);
INSERT INTO route_role (route_id, role_id) VALUES (7, 2);
INSERT INTO route_role (route_id, role_id) VALUES (9, 2);
INSERT INTO route_role (route_id, role_id) VALUES (1, 3);
INSERT INTO route_role (route_id, role_id) VALUES (2, 3);
INSERT INTO route_role (route_id, role_id) VALUES (3, 3);
INSERT INTO route_role (route_id, role_id) VALUES (4, 3);
INSERT INTO route_role (route_id, role_id) VALUES (5, 3);
INSERT INTO route_role (route_id, role_id) VALUES (7, 3);
--mapping of users and roles
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
--listings
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (1,'Looking for a new home for my neighbours cat due to relocation. Fluff is a gentle and friendly cat who likes to sleep a lot :)', '/images/cat1.png', 'tel aviv', 'Fluff is looking for a new family', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (2,'Unfortunately, the owner of Whiskers has cat allergy so we have to find for him a new home', '/images/cat2.png', 'bat yam', 'Urgent! Whiskers needs a new home', 'cat', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (3,'Yesterday we found a very friendly street dog who is in need of a new home', '/images/dog1.png', 'tel aviv', 'Jack the dog wants a new family!', 'dog', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (4,'My parents told me to find a new home for our hamster! Sad :(', '/images/hamster1.png', 'rishon le-tsion', 'Hamster is looking for a new home', 'hamster', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (5,'This wonderful cat needs a new home', '/images/cat3.png', 'tel aviv', 'Cat for adoption', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (6,'Looking for a new home for my parents dog', '/images/dog2.png', 'tel aviv', 'Dog', 'dog', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (7,'Helping my friend to find a new family for this dog from local shelter', '/images/dog3.png', 'haifa', 'Dog for adoption', 'dog', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (8,'Urgent! I am moving to a different country and need to find a new home for my gunea pig', '/images/gunea_pig1.png', 'tel aviv', 'Gunea pig for adoption!', 'gunea pig', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (9,'My moms cat is looking for a new home. He likes tuna a lot!', '/images/cat4.png', 'holon', 'Cat', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (10,'Looking for a new home for my friends parrot', '/images/parrot1.png', 'holon', 'Parrot for adoption', 'parrot', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (listing_id, description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES (11,'This dog needs new family! He is very friendly and likes to play', '/images/dog4.png', 'haifa', 'Friendly dog', 'dog', true, 'panda', 1, '+97255000000');