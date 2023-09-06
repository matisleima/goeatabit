-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-06 06:29:39.363

-- tables
-- Table: district
CREATE TABLE district (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT district_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    offer_id int  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: food_group
CREATE TABLE food_group (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    image_id int  NOT NULL,
    CONSTRAINT food_group_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    address varchar(255)  NOT NULL,
    district_id int  NOT NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: offer
CREATE TABLE offer (
    id serial  NOT NULL,
    time time  NOT NULL,
    date date  NOT NULL,
    price money  NOT NULL,
    seats int  NOT NULL,
    name int  NOT NULL,
    description varchar(255)  NOT NULL,
    food_group_id int  NOT NULL,
    status char(1)  NOT NULL,
    user_id int  NOT NULL,
    rating_id int  NOT NULL,
    CONSTRAINT offer_pk PRIMARY KEY (id)
);

-- Table: rating
CREATE TABLE rating (
    id serial  NOT NULL,
    "level" int  NOT NULL,
    CONSTRAINT rating_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    first_name varchar(255)  NOT NULL,
    last_name varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    role_id int  NOT NULL,
    image_id int  NOT NULL,
    location_id int  NOT NULL,
    e_mail varchar(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_10_User (table: event)
ALTER TABLE event ADD CONSTRAINT Table_10_User
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Table_10_offer (table: event)
ALTER TABLE event ADD CONSTRAINT Table_10_offer
    FOREIGN KEY (offer_id)
    REFERENCES offer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_image (table: user)
ALTER TABLE "user" ADD CONSTRAINT User_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_location (table: user)
ALTER TABLE "user" ADD CONSTRAINT User_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: User_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT User_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: food_group_image (table: food_group)
ALTER TABLE food_group ADD CONSTRAINT food_group_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: location_district (table: location)
ALTER TABLE location ADD CONSTRAINT location_district
    FOREIGN KEY (district_id)
    REFERENCES district (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: offer_food_group (table: offer)
ALTER TABLE offer ADD CONSTRAINT offer_food_group
    FOREIGN KEY (food_group_id)
    REFERENCES food_group (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: offer_rating (table: offer)
ALTER TABLE offer ADD CONSTRAINT offer_rating
    FOREIGN KEY (rating_id)
    REFERENCES rating (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: offer_user (table: offer)
ALTER TABLE offer ADD CONSTRAINT offer_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

