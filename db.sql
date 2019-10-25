DROP DATABASE IF EXISTS evaluacion_3;

CREATE DATABASE IF NOT EXISTS evaluacion_3 CHARACTER SET UTF8MB4;
USE evaluacion_3;

CREATE TABLE IF NOT EXISTS users (
	id INT AUTO_INCREMENT,
	username VARCHAR(50) UNIQUE NOT NULL,
	pass VARCHAR(200) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	rut VARCHAR(10) NOT NULL,
	createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_users PRIMARY KEY(id, username)
);

INSERT INTO users(username, pass, firstname, lastname, rut) VALUES 
("bbelmar", "b1234", "Boris", "Belmar", "18594160-4"), 
("fbrinckfeldt", "f1234", "Francisca", "Brinckfeldt", "18594160-4");

SELECT * FROM users;