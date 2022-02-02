--USER INSERTS
INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (1,'student@gmail.com','studentFirstName','studentLastName','student');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (2,'professor1@gmail.com','professor1','professor1','professor1');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (3,'admin@gmail.com','admin','admin','admin');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (4,'student4@gmail.com','student4FirstName','student4LastName','student4');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (5,'student5@gmail.com','student5FirstName','student5LastName','student5');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (6,'student6@gmail.com','student6FirstName','student6LastName','student6');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (7,'student7@gmail.com','student7FirstName','student7LastName','student7');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (8,'student8@gmail.com','student8FirstName','student8LastName','student8');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (9,'student9@gmail.com','student9FirstName','student9LastName','student9');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (10,'student10@gmail.com','student10FirstName','student10LastName','student10');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (11,'student11@gmail.com','student11FirstName','student11LastName','student11');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (12,'student12@gmail.com','student12FirstName','student12LastName','student12');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (13,'student13@gmail.com','student13FirstName','student13LastName','student13');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (14,'student14@gmail.com','student14FirstName','student14LastName','student14');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (15,'student15@gmail.com','student15FirstName','student15LastName','student15');

--STUDENT INSERTS
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (1,1);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (2,4);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (3,5);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (4,6);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (5,7);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (6,8);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (7,9);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (8,10);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (9,11);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (10,12);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (11,13);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (12,14);
INSERT INTO `student_service`.`student` (`id`, `user_id`) VALUES (13,15);

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
VALUES (1,'2022-11-23 12:00:00','2021-01-23 12:00:00',1);

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (2,'2021-11-23 12:00:00','2020-01-23 12:00:00',1);

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (3,'2020-11-23 12:00:00','2019-01-23 12:00:00',1);

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (4,'2019-11-23 12:00:00','2018-01-23 12:00:00',2);

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (5,'2022-11-23 12:00:00','2022-01-23 12:00:00',2);

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`)
VALUES (6,'2022-11-23 12:00:00','2022-01-23 12:00:00',3);

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