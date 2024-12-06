CREATE TABLE medicos (
	id BIGSERIAL PRIMARY KEY,
	n o m e VARCHAR(100) NOT NULL UNIQUE,
	e m a i l  VARCHAR(100) NOT NULL UNIQUE,
	c r m  VARCHAR(6) NOT NULL UNIQUE,
	e s p e c i a l i d a d e  VARCHAR(100) NOT NULL,
 	l o g r a d o u r o  VARCHAR(100) NOT NULL,
	b a i r r o  VARCHAR(100) NOT NULL,
	c e p  VARCHAR(8) NOT NULL,	
	c i d a d e  VARCHAR(100) NOT NULL,
	u f  CHAR(2) NOT NULL,
	n u m e r o  VARCHAR(20), 
	c o m p l e m e n t o  VARCHAR(100)	
);