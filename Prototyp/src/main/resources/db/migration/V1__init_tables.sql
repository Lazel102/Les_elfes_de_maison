CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);



-- Create table for Event
CREATE TABLE event (
                       id serial primary key,
                       title VARCHAR(255) NOT NULL,
                       kitchen_address VARCHAR(255) NOT NULL,
                       kitchen_image_url VARCHAR(255),
                       number_of_participants INTEGER,
                       datum DATE NOT NULL
);

-- Create table for Recipe
CREATE TABLE recipe (
                        id serial PRIMARY KEY,
                        chef VARCHAR(255) NOT NULL,
                        title VARCHAR(255) NOT NULL,
                        ingredients TEXT NOT NULL,
                        instructions TEXT NOT NULL,
                        event bigint,
                        image VARCHAR(255),
                        event_key BIGINT,
                        FOREIGN KEY (event) REFERENCES event (id) ON DELETE CASCADE
);




