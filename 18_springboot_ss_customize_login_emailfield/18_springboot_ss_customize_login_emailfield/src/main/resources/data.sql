INSERT into role_security (name)
SELECT 'ROLE_USER'
WHERE NOT EXISTS(
	SELECT 1 FROM role_security where name = 'ROLE_USER'
);


INSERT into role_security (name)
SELECT 'ROLE_ADMIN'
WHERE NOT EXISTS(
	SELECT 1 FROM role_security where name = 'ROLE_ADMIN'
);

INSERT into user_security (email,password)
SELECT 'dbuser@gmail.com','$2a$10$rLQrSz9sv4pLJ.kPgeqxm.pEdPxQ5vRZeTtTLU0uzB4/Z9uCGwsbS'
WHERE NOT EXISTS(
	SELECT 1 FROM user_security where email = 'dbuser@gmail.com'
);

INSERT into role_user (uid,rid)
SELECT 1,1
WHERE NOT EXISTS(
	SELECT 1 FROM role_user where uid = 1 and rid=1
);

INSERT into role_user (uid,rid)
SELECT 1,2
WHERE NOT EXISTS(
	SELECT 1 FROM role_user where uid = 1 and rid=2
);

