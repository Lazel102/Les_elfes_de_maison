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

-- Insert default roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insert sample users (replace 'your_password' with desired password, properly hashed)
INSERT INTO users (username, password) VALUES ('Yannilloni', '$2a$12$nTo4XE4e1bgyCRsOQZtOPulfojFqIuIGcVpjR4Q4rGdji/2FMFH/a
');
INSERT INTO users (username, password) VALUES ('Yasagne', '$2a$12$swg/hgzzSN3RntFlHMy0JOvHfGg7CR.Mj0B5TSdwONz9CUWFwMmzq
');

-- Assign roles to sample users (assuming the roles have IDs 1 for ROLE_USER and 2 for ROLE_ADMIN)
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2); -- user has ROLE_USER
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2); -- admin has ROLE_ADMIN
