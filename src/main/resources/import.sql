--USER INSERTS
INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (1,'student@gmail.com','studentFirstName','studentLastName','student');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (2,'professor1@gmail.com','professor1','professor1','professor1');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (3,'admin@gmail.com','admin','admin','admin');

--STUDENT INSERTS
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (1,1);

--LECTURER INSERTS
INSERT INTO `student_service`.`lecturer` (`id`, `user_id`) VALUES (1,2);

--ADMIN INSERTS
INSERT INTO `student_service`.`admin` (`id`, `user_id`) VALUES (1,3);

--COURSE INSERTS
INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (1,"testCode1", 5, 'Object oriented programming');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (2,"testCode2", 3, 'Java1');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (3,"testCode3", 4, 'Java2');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (4,"testCode4", 4, 'Math1');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (5,"testCode5", 6, 'Math2');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (6,"testCode6", 8, 'Algorithms');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (7,"testCode7", 5, 'Test123');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (8,"testCode8", 7, 'Blabla');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (9,"testCode9", 3, 'Hello');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (10,"testCode10", 2, 'From');

INSERT INTO `student_service`.`course` (`id`, `code`, `ects`, `name`)
VALUES (11,"testCode11", 4, 'Other Side');

--COURSE INSTANCES INSERTS
INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (1,'2022-11-23 12:00:00','2022-01-23 12:00:00',1);

--ACCOUNT INSERTS
INSERT INTO `student_service`.`account` (`id`, `account_number`, `student_id`)
VALUES (1,'AC23232323',1);

--DOCUMENT INSERTS
INSERT INTO `student_service`.`document` (`id`, `title`, `url`, `student_id`)
VALUES (1,'Acceptance letter','http://localhost:9000/2313132',1);

--ENROLLMENT INSERTS
INSERT INTO `student_service`.`enrollment` (`id`, `points`, `course_instance`, `student_id`)
 VALUES (1,33,1,1);

--LECTURE INSTANCE INSERTS
INSERT INTO `student_service`.`lecture_instance` (`id`, `course_instance`)
VALUES (1,1);

--LECTURER__LECTURE INSTANCE INSERTS (Connecting table)
INSERT INTO `student_service`.`lecturer_lecture_instances` (`lecturers_id`, `lecture_instances_id`)
VALUES (1,1);

--PAYMENT INSERTS
INSERT INTO `student_service`.`payment` (`id`, `amount`, `date`, `account_id`)
VALUES (1,2000.00,'2022-01-23 12:00:00',1);