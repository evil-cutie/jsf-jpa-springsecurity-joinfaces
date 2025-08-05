--users
INSERT INTO users (password, username, user_email, active) VALUES('$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'panda', 'panda@gmail.com', true);
INSERT INTO users (password, username, user_email, active) VALUES ('$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'not_admin', 'notadmin@gmail.com', true);
INSERT INTO users (password, username, user_email, active) VALUES('$2a$12$Oots1YAVyUk.etOo9WKaH.n97qrr0thU6fLs2/AdiMwLpyafefGnm', 'catlover', 'hunter2@gmail.com', true);

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
INSERT INTO routes (route_url) VALUES ('/api/users/register');
INSERT INTO routes (route_url) VALUES ('/redirect.xhtml');

--roles
INSERT INTO roles (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (role_name) VALUES ('ROLE_USER');
INSERT INTO roles (role_name) VALUES ('ROLE_GUEST');

--animals
INSERT INTO animals (animal_type) VALUES ('cat');
INSERT INTO animals (animal_type) VALUES ('dog');
INSERT INTO animals (animal_type) VALUES ('parrot');
INSERT INTO animals (animal_type) VALUES ('fish');
INSERT INTO animals (animal_type) VALUES ('hamster');
INSERT INTO animals (animal_type) VALUES ('guinea pig');

--cities
INSERT INTO cities (city_name) VALUES ('Tel Aviv');
INSERT INTO cities (city_name) VALUES ('Jerusalem');
INSERT INTO cities (city_name) VALUES ('Haifa');
INSERT INTO cities (city_name) VALUES ('Ashdod');
INSERT INTO cities (city_name) VALUES ('Rishon LeZion');
INSERT INTO cities (city_name) VALUES ('Beersheba');
INSERT INTO cities (city_name) VALUES ('Petah Tikva');
INSERT INTO cities (city_name) VALUES ('Netanya');
INSERT INTO cities (city_name) VALUES ('Bat Yam');
INSERT INTO cities (city_name) VALUES ('Ramat Gan');
INSERT INTO cities (city_name) VALUES ('Herzliya');
INSERT INTO cities (city_name) VALUES ('Rehovot');

--mapping of routes and roles
--ROLE_ADMIN
INSERT INTO route_role (route_id, role_id) VALUES (1, 1);
INSERT INTO route_role (route_id, role_id) VALUES (2, 1);
INSERT INTO route_role (route_id, role_id) VALUES (3, 1);
INSERT INTO route_role (route_id, role_id) VALUES (4, 1);
INSERT INTO route_role (route_id, role_id) VALUES (5, 1);
INSERT INTO route_role (route_id, role_id) VALUES (6, 1);
INSERT INTO route_role (route_id, role_id) VALUES (8, 1);
INSERT INTO route_role (route_id, role_id) VALUES (9, 1);
INSERT INTO route_role (route_id, role_id) VALUES (10, 1);
INSERT INTO route_role (route_id, role_id) VALUES (11, 1);
INSERT INTO route_role (route_id, role_id) VALUES (13, 1);
--ROLE_USER
INSERT INTO route_role (route_id, role_id) VALUES (1, 2);
INSERT INTO route_role (route_id, role_id) VALUES (2, 2);
INSERT INTO route_role (route_id, role_id) VALUES (3, 2);
INSERT INTO route_role (route_id, role_id) VALUES (4, 2);
INSERT INTO route_role (route_id, role_id) VALUES (5, 2);
INSERT INTO route_role (route_id, role_id) VALUES (6, 2);
INSERT INTO route_role (route_id, role_id) VALUES (9, 2);
INSERT INTO route_role (route_id, role_id) VALUES (10, 2);
INSERT INTO route_role (route_id, role_id) VALUES (11, 2);
INSERT INTO route_role (route_id, role_id) VALUES (13, 2);
--ROLE_GUEST
INSERT INTO route_role (route_id, role_id) VALUES (1, 3);
INSERT INTO route_role (route_id, role_id) VALUES (2, 3);
INSERT INTO route_role (route_id, role_id) VALUES (3, 3);
INSERT INTO route_role (route_id, role_id) VALUES (4, 3);
INSERT INTO route_role (route_id, role_id) VALUES (5, 3);
INSERT INTO route_role (route_id, role_id) VALUES (7, 3);
INSERT INTO route_role (route_id, role_id) VALUES (10, 3);
INSERT INTO route_role (route_id, role_id) VALUES (12, 3);
INSERT INTO route_role (route_id, role_id) VALUES (13, 3);

--mapping of users and roles
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);

--listings
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Looking for a new home for my neighbours cat due to relocation. Fluff is a gentle and friendly cat who likes to sleep a lot :)', '/images/cat1.png', 'Fluff is looking for a new family', true, 2, 1, 1,'+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Unfortunately, the owner of Whiskers has cat allergy so we have to find for him a new home', '/images/cat2.png', 'Urgent! Whiskers needs a new home',true, 5,1, 2, '+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Yesterday we found a very friendly street dog who is in need of a new home', '/images/dog1.png', 'Jack the dog wants a new family!', true, 3, 2, 1,'+1234567');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('My parents told me to find a new home for our hamster! Sad :(', '/images/hamster1.png', 'Hamster is looking for a new home', true, 12, 5, 1, '+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('This wonderful cat needs a new home', '/images/cat3.png', 'Cat for adoption', true, 5,1, 1, '+123123');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Looking for a new home for my parents dog', '/images/dog2.png', 'Dog', true, 7, 2, 2,'+972111111');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Helping my friend to find a new family for this dog from local shelter', '/images/dog3.png', 'Dog for adoption', true, 3, 2, 2,'+972123123');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Urgent! I am moving to a different country and need to find a new home for my gunea pig', '/images/gunea_pig1.png', 'Gunea pig for adoption!', true,9, 6, 2, '+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('My moms cat is looking for a new home. He likes tuna a lot!', '/images/cat4.png', 'Cat', true, 2, 1, 1,'+972555555');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Looking for a new home for my friends parrot', '/images/parrot1.png', 'Parrot for adoption', true, 1, 3, 1,'+123123123');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('This dog needs new family! He is very friendly and likes to play', '/images/dog4.png', 'Friendly dog', true, 8, 2, 2,'+1234567890');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('New home needed for Chubbs! His owner cannot take care of him', '/images/dog7.png', 'New friend for you', true, 7, 2, 2,'+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('They are really cute, can adopt separately', '/images/dog8.png', 'Two pups for adoption', true, 10, 2, 2,'+97211111');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Urgent! Need to rehome a dog due to sudden allergy', '/images/dog5.png', 'Urgent adoption! Help!', true, 9, 2, 1,'+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('She likes to go on hikes and play fetch. Message me for more info (please no calls)', '/images/dog6.png', 'Help me to find a new family for Bella!', true, 1, 2, 1,'+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('A couple of parrots for adoption. They are very sweet and know how to talk, you wont get bored with em!', '/images/parrot2.png', 'Parrots', true, 2, 3, 3,'+97255000000');
INSERT INTO listings (description, listing_image, listing_title, active, city_id, animal_id, user_id, phone) VALUES ('Please help, my roommate got herself a cat so i have to rehome my parrots', '/images/parrot3.png', 'Urgent adoption', true, 2, 3, 3,'+97255000000');