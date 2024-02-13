DROP TABLE IF EXISTS dbuser CASCADE;


CREATE TABLE dbuser (
                        id SERIAL,
                        username VARCHAR(250) NOT NULL,
                        password VARCHAR(250) NOT NULL,
                        role VARCHAR(250) NOT NULL
);
INSERT INTO dbuser (username, password, role) VALUES ('user', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'USER'),
                                                     ('admin', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'ADMIN'),
                                                     ('moderator', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'MODERATOR');;