--users
INSERT INTO users (password, username, user_email, active) VALUES('$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'panda', 'panda@gmail.com', true);
INSERT INTO users (password, username, user_email, active) VALUES ('$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'not_admin', 'notadmin@gmail.com', true);
--routes
INSERT INTO routes (route_url) VALUES ('/index.xhtml');
INSERT INTO routes (route_url) VALUES ('/403.xhtml');
INSERT INTO routes (route_url) VALUES ('/404.xhtml');
INSERT INTO routes (route_url) VALUES ('/charity.xhtml');
INSERT INTO routes (route_url) VALUES ('/login.xhtml');
INSERT INTO routes (route_url) VALUES ('/profile.xhtml');
INSERT INTO routes (route_url) VALUES ('/registration.xhtml');
INSERT INTO routes (route_url) VALUES ('/admin/adashboard.xhtml');
INSERT INTO routes (route_url) VALUES ('/adoption.xhtml');
INSERT INTO routes (route_url) VALUES ('/images/favicon.ico');
INSERT INTO routes (route_url) VALUES ('/history.xhtml');
--roles
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_USER');
INSERT INTO roles (role_name) VALUES ('ROLE_GUEST');
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
INSERT INTO route_role (route_id, role_id) VALUES (9, 3);
INSERT INTO route_role (route_id, role_id) VALUES (9, 1);
INSERT INTO route_role (route_id, role_id) VALUES (9, 2);
INSERT INTO route_role (route_id, role_id) VALUES (10, 1);
INSERT INTO route_role (route_id, role_id) VALUES (10, 2);
--mapping of users and roles
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
--listings
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Looking for a new home for my neighbours cat due to relocation. Fluff is a gentle and friendly cat who likes to sleep a lot :)', '/images/cat1.png', 'tel aviv', 'Fluff is looking for a new family', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Unfortunately, the owner of Whiskers has cat allergy so we have to find for him a new home', '/images/cat2.png', 'bat yam', 'Urgent! Whiskers needs a new home', 'cat', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Yesterday we found a very friendly street dog who is in need of a new home', '/images/dog1.png', 'tel aviv', 'Jack the dog wants a new family!', 'dog', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('My parents told me to find a new home for our hamster! Sad :(', '/images/hamster1.png', 'rishon le-tsion', 'Hamster is looking for a new home', 'hamster', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('This wonderful cat needs a new home', '/images/cat3.png', 'tel aviv', 'Cat for adoption', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Looking for a new home for my parents dog', '/images/dog2.png', 'tel aviv', 'Dog', 'dog', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Helping my friend to find a new family for this dog from local shelter', '/images/dog3.png', 'haifa', 'Dog for adoption', 'dog', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Urgent! I am moving to a different country and need to find a new home for my gunea pig', '/images/gunea_pig1.png', 'tel aviv', 'Gunea pig for adoption!', 'gunea pig', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('My moms cat is looking for a new home. He likes tuna a lot!', '/images/cat4.png', 'holon', 'Cat', 'cat', true, 'panda', 1, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('Looking for a new home for my friends parrot', '/images/parrot1.png', 'holon', 'Parrot for adoption', 'parrot', true, 'not_admin', 2, '+97255000000');
INSERT INTO listings (description, listing_image, animal_location, animal_name, animal_type, active, username, user_id, phone) VALUES ('This dog needs new family! He is very friendly and likes to play', '/images/dog4.png', 'haifa', 'Friendly dog', 'dog', true, 'panda', 1, '+97255000000');