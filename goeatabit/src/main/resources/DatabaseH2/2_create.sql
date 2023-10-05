-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-06 08:30:43.146

-- tables
-- Table: contact
CREATE TABLE eat.contact (
                             id SERIAL NOT NULL,
                             user_id int  NOT NULL,
                             image_id int  NULL,
                             firstname VARCHAR(255)  NOT NULL,
                             lastname VARCHAR(255)  NOT NULL,
                             CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: district
CREATE TABLE eat.district (
                              id SERIAL NOT NULL,
                              name VARCHAR(255)  NOT NULL,
                              CONSTRAINT district_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE eat.event (
                           id SERIAL NOT NULL,
                           user_id int  NOT NULL,
                           offer_id int  NOT NULL,
                           status char(1)  NOT NULL,
                           CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: food_group
CREATE TABLE eat.food_group (
                                id SERIAL NOT NULL,
                                name VARCHAR(255)  NOT NULL,
                                CONSTRAINT food_group_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE eat.image (
                           id SERIAL NOT NULL,
                           data bytea  NOT NULL,
                           status char(1)  NOT NULL,
                           food_group_id int NULL,
                           CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE eat.location (
                              id SERIAL NOT NULL,
                              user_id int  NOT NULL,
                              address VARCHAR(255)  NOT NULL,
                              district_id int  NOT NULL,
                              longitude decimal(8,6)  NULL,
                              latitude decimal(8,6)  NULL,
                              CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: offer
CREATE TABLE eat.offer (
                           id SERIAL NOT NULL,
                           user_id int  NOT NULL,
                           location_id int  NOT NULL,
                           time VARCHAR(8)  NOT NULL,
                           date VARCHAR  NOT NULL,
                           price decimal(4,2)  NOT NULL,
                           total_portions int  NOT NULL,
                           name VARCHAR(255)  NOT NULL,
                           description VARCHAR(255)  NOT NULL,
                           food_group_id int  NOT NULL,
                           status char(1)  NOT NULL,
                           CONSTRAINT offer_pk PRIMARY KEY (id)
);

-- Table: rating
CREATE TABLE eat.rating (
                            id SERIAL NOT NULL,
                            user_id int  NOT NULL,
                            counter int  NOT NULL DEFAULT 0,
                            sum int  NOT NULL DEFAULT 0,
                            CONSTRAINT rating_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE eat.role (
                          id SERIAL NOT NULL,
                          name VARCHAR(255)  NOT NULL,
                          CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE eat."user" (
                            id SERIAL NOT NULL,
                            role_id int  NULL,
                            rating decimal(2,1)  NOT NULL,
                            status char(1)  NOT NULL,
                            email VARCHAR(255)  NOT NULL,
                            password VARCHAR(255)  NOT NULL,
                            CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_10_user (table: event)
ALTER TABLE eat.event ADD CONSTRAINT Table_10_user
    FOREIGN KEY (user_id)
        REFERENCES eat."user" (id)
        
           
;

-- Reference: Table_10_offer (table: event)
ALTER TABLE eat.event ADD CONSTRAINT Table_10_offer
    FOREIGN KEY (offer_id)
        REFERENCES eat.offer (id)
        
           
;

-- Reference: user_role (table: user)
ALTER TABLE eat."user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES eat.role (id)
        
           
;

-- Reference: contact_image (table: contact)
ALTER TABLE eat.contact ADD CONSTRAINT contact_image
    FOREIGN KEY (image_id)
        REFERENCES eat.image (id)
        
           
;

-- Reference: contact_user (table: contact)
ALTER TABLE eat.contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
        REFERENCES eat."user" (id)
        
           

;-- Reference: image_food_group (table: image)
ALTER TABLE eat.image ADD CONSTRAINT image_food_group
    FOREIGN KEY (food_group_id)
        REFERENCES eat.food_group (id)
        
           
;

-- Reference: location_district (table: location)
ALTER TABLE eat.location ADD CONSTRAINT location_district
    FOREIGN KEY (district_id)
        REFERENCES eat.district (id)
        
           
;

-- Reference: location_user (table: location)
ALTER TABLE eat.location ADD CONSTRAINT location_user
    FOREIGN KEY (user_id)
        REFERENCES eat."user" (id)
        
           
;

-- Reference: offer_food_group (table: offer)
ALTER TABLE eat.offer ADD CONSTRAINT offer_food_group
    FOREIGN KEY (food_group_id)
        REFERENCES eat.food_group (id)
        
           
;

-- Reference: offer_user (table: offer)
ALTER TABLE eat.offer ADD CONSTRAINT offer_location
    FOREIGN KEY (location_id)
        REFERENCES eat.location (id)
        
           
;
-- Reference: offer_user (table: offer)
ALTER TABLE eat.offer ADD CONSTRAINT offer_user
    FOREIGN KEY (user_id)
        REFERENCES eat."user" (id)
        
           
;

-- Reference: rating_user (table: rating)
ALTER TABLE eat.rating ADD CONSTRAINT rating_user
    FOREIGN KEY (user_id)
        REFERENCES eat."user" (id)
        
           
;

-- End of file.