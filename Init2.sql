DROP TABLE IF EXISTS ATTENDANCE_KEY;

CREATE TABLE `ATTENDANCE_KEY` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` char(10) NOT NULL,
  `course_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `ramdon_key` varchar(10) DEFAULT NULL,
  `attend_state` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attendance_key_teacher` (`teacher_id`),
  KEY `fk_attendance_key_courses_id` (`course_id`),
  CONSTRAINT `fk_attendance_key_courses_id` FOREIGN KEY (`course_id`) REFERENCES `COURSES` (`id`),
  CONSTRAINT `fk_attendance_key_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `USERS` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;