CREATE TABLE roles (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
                            user_id INTEGER NOT NULL,
                            role_id INTEGER NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                            FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

-- Create table for Event
CREATE TABLE event (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       kitchen_address VARCHAR(255) NOT NULL,
                       kitchen_image_url VARCHAR(255),
                       number_of_participants INTEGER,
                       date VARCHAR(255) NOT NULL
);

-- Create table for Recipe
CREATE TABLE recipe (
                        chef VARCHAR(255) NOT NULL,
                        title VARCHAR(255) NOT NULL,
                        ingredients TEXT NOT NULL,
                        instructions TEXT NOT NULL,
                        image VARCHAR(255),
                        event_id INTEGER,
                        FOREIGN KEY (event_id) REFERENCES event (id) ON DELETE CASCADE
);

-- Insert default roles
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('ADMIN');


