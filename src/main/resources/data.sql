INSERT INTO post (id, title            , content                           , description             , created_at       , updated_at       )
VALUES           (1 ,'Spring Framework', 'Learn Spring Framework with Khoa', 'Learn Spring Framework', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comment (id, name             , email              , body              , post_id, created_at       , updated_at       )
VALUES              (1 , 'Phạm Gia Ân', 'an.pg@gmail.com', 'Bài viết rất hay', 1      , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

--INSERT INTO users (name, email, username, password, role, created_at, updated_at)
--VALUES ('Thu Uyn', 'uyn.ptt@gmail.com', 'uyn.ptt', '123456A', 'EMPLOYEE', NOW(), NOW()),
--        ('Agin', 'angin@gmail.com', 'agin', '123456A', 'EMPLOYEE', NOW(), NOW());
