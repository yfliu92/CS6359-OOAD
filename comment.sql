USE LOC;
DROP TABLE IF EXISTS COMMENTS;

CREATE TABLE COMMENTS (
  id int NOT NULL AUTO_INCREMENT,
  rating int NOT NULL default 0,
  content longtext,
  course_id int(11) not null ,
  user_id char(10) not null ,
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES LOC.COURSES(id),
  FOREIGN KEY (user_id) REFERENCES LOC.USERS(id)
);
