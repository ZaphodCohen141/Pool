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
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    answer_id INT NOT NULL,
    PRIMARY KEY(question_id),
    FOREIGN KEY(user_id) REFERENCES users(id)
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
VALUES('Where are we going?','a. Day in, day out','b. The night is young',
'c. Need for survival is clear','d. Just so you know we don''t');


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

