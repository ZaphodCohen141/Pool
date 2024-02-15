DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT NOT NULL,
    total_ans INT NOT NULL,
    questions_list varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY(id)
);

CREATE TABLE replies(
    question_id INT NOT NULL,
    user_id INT NOT NULL,
    answer_id INT NOT NULL,
    PRIMARY KEY(question_id)
);

CREATE TABLE questions(
    question_id INT NOT NULL AUTO_INCREMENT,
    question_text varchar(255) NOT NULL DEFAULT '',
    ans_1 varchar(255) NOT NULL DEFAULT '',
    ans_2 varchar(255) NOT NULL DEFAULT '',
    ans_3 varchar(255) NOT NULL DEFAULT '',
    ans_4 varchar(255) NOT NULL DEFAULT '',
    PRIMARY KEY (question_id)
);

INSERT INTO questions (question_text,ans_1,ans_2,ans_3,ans_4)
VALUES('What is love?','a. Oh baby, don''t hurt me','b. Don''t hurt me',
'c. No more','d. No, I don''t know why you''re not fair'),
('How can you say I go about things the wrong way?', 'a.I am human and I need to be loved',
'b. Just like everybody else does', 'c.You shut your mouth','d. How can you say'),
('Are Friends Electric?','a. Only mine''s broke down','b. And now I''ve no-one to love',
'c. So I found out your reason', 'd. for the phone calls and smiles'),
('Should I Stay Or Should I Go?','a. If you say that you are mine', 'b. I''ll be here till the end of time',
'c. So you got to let me know','d. It''s always tease');


INSERT INTO replies (question_id,user_id,answer_id)
VALUES (1,1,2),(2,1,3),(3,1,1),(4,1,4);
--CREATE TABLE a_to_q _1 (
--    user_id int NOT NULL,
--    q_id int NOT NULL,
--    answer varchar(255) NOT NULL DEFAULT '',
--    PRIMARY KEY(q_id)
--);
--
--CREATE TABLE a_to_q _2 (
--    user_id int NOT NULL,
--    q_id int NOT NULL,
--    answer varchar(255) NOT NULL DEFAULT '',
--    PRIMARY KEY(q_id)
--);
--
--CREATE TABLE a_to_q _3 (
--    user_id int NOT NULL,
--    q_id int NOT NULL,
--    answer varchar(255) NOT NULL DEFAULT '',
--    PRIMARY KEY(q_id)
--);
--
--CREATE TABLE a_to_q _4 (
--    user_id int NOT NULL,
--    q_id int NOT NULL,
--    answer varchar(255) NOT NULL DEFAULT '',
--    PRIMARY KEY(q_id)
--);
--
--CREATE TABLE a_to_q _5 (
--    user_id int NOT NULL,
--    q_id int NOT NULL,
--    answer varchar(255) NOT NULL DEFAULT '',
--    PRIMARY KEY(q_id)
--);

