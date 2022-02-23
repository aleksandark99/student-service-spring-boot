--ROLE INSERTS
INSERT INTO `student_service`.`role`(`id`,`description`,`name`)VALUES (1,'Admin','ROLE_ADMIN');
INSERT INTO `student_service`.`role`(`id`,`description`,`name`)VALUES (2,'Student','ROLE_STUDENT');
INSERT INTO `student_service`.`role`(`id`,`description`,`name`)VALUES (3,'Professor','ROLE_PROFESSOR');
INSERT INTO `student_service`.`role`(`id`,`description`,`name`)VALUES (4,'Assistant','ROLE_ASSISTANT');

--USER INSERTS
INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`,`role_id`)
VALUES (1,'s','s','s','$2a$12$7wQ2UiM2FYac90mnmi.v0ONxM6NRHOwTYD75Uuqkvdj71ndGj3WD.',2);

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`,`role_id`)
VALUES (2,'p','p','p','$2a$12$SmhEc.S/7I4gVZNgNROwsOF.JKPCB3XfBxTaP9oIlXtfhcNUKSIjy',3);

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`,`role_id`)
VALUES (3,'a','a','a','$2a$12$dM6A/PMBOtylhztcU.TbR.r177ileZzE84QBHgIIaEcAEZCcSLfqC',1);

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

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (16,'professor16@gmail.com','professor16','professor16','professor16');

INSERT INTO `student_service`.`user` (`id`, `email`, `first_name`, `last_name`, `password`)
VALUES (17,'professor16@gmail.com','professor17','professor17','professor17');

--STUDENT INSERTS
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (1,1, "SF01");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (2,4, "SF04");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (3,5, "SF05");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (4,6, "SF06");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (5,7, "SF07");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (6,8, "SF08");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (7,9, "SF09");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (8,10, "SF010");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (9,11, "SF011");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (10,12, "SF012");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (11,13, "SF013");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (12,14, "SF014");
INSERT INTO `student_service`.`student` (`id`, `user_id`, `index_`) VALUES (13,15, "SF015");

--LECTURER INSERTS
INSERT INTO `student_service`.`lecturer` (`id`, `user_id`, `lecturer_code`) VALUES (1,2, 'lecturerCode2');
INSERT INTO `student_service`.`lecturer` (`id`, `user_id`, `lecturer_code`) VALUES (2,16, 'lecturerCode16');
INSERT INTO `student_service`.`lecturer` (`id`, `user_id`, `lecturer_code`) VALUES (3,17, 'lecturerCode17');

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
INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (1,'2022-11-23 12:00:00','2021-01-23 12:00:00',1,'short description 1');

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (2,'2021-11-23 12:00:00','2020-01-23 12:00:00',1,'short description 2');

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (3,'2020-11-23 12:00:00','2019-01-23 12:00:00',1,'short description 3');

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (4,'2019-11-23 12:00:00','2018-01-23 12:00:00',2,'short description 4');

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (5,'2022-11-23 12:00:00','2022-01-23 12:00:00',2,'short description 5');

INSERT INTO `student_service`.`course_instance` (`id`, `end_date`, `start_date`, `course_id`,`description`)
VALUES (6,'2022-11-23 12:00:00','2022-01-23 12:00:00',3,'short description 6');

--DOCUMENT INSERTS
--INSERT INTO `student_service`.`document` (`id`, `title`, `url`, `student_id`)
--VALUES (1,'Acceptance letter','http://localhost:9000/2313132',1);

--ENROLLMENT INSERTS
INSERT INTO `student_service`.`enrollment` (`id`, `points`, `course_instance`, `student_id`)
 VALUES (1,33,1,1);



--LECTURE INSTANCE INSERTS
INSERT INTO `student_service`.`lecture_instance` (`id`, `course_instance`)
VALUES (1,1);
INSERT INTO `student_service`.`lecture_instance` (`id`, `course_instance`)
VALUES (2,1);
INSERT INTO `student_service`.`lecture_instance` (`id`, `course_instance`)
VALUES (3,1);

--LECTURER__LECTURE INSTANCE INSERTS (Connecting table)
INSERT INTO `student_service`.`lecturer_lecture_instances` (`lecturers_id`, `lecture_instances_id`)
VALUES (1,1);
INSERT INTO `student_service`.`lecturer_lecture_instances` (`lecturers_id`, `lecture_instances_id`)
VALUES (2,2);
INSERT INTO `student_service`.`lecturer_lecture_instances` (`lecturers_id`, `lecture_instances_id`)
VALUES (3,3);



--ACCOUNT INSERTS
INSERT INTO `student_service`.`account` (`id`, `account_number`,`balance`, `student_id`)
VALUES (1,'AC23232323',2400.00,1);

--PAYMENT INSERTS
INSERT INTO `student_service`.`payment` (`id`, `amount`, `date`, `account_id`)
VALUES (1,2000.00,'2022-01-23 12:00:00',1);

INSERT INTO `student_service`.`payment` (`id`, `amount`, `date`, `account_id`)
VALUES (2,-200.00,'2022-01-23 12:00:00',1);

--EXAM PERIOD
INSERT INTO `student_service`.`exam_period`(`id`,`end_date`,`name`,`start_date`)
VALUES(1,'2022-04-23','January exam period','2022-01-23');

--TEST
INSERT INTO `student_service`.`test`(`id`,`date`,`max_points`,`place`,`title`,`course_instance_id`,`period_id`)
VALUES(1,'2022-04-20',50,'NTP333','final exam',1,1);

INSERT INTO `student_service`.`test`(`id`,`date`,`max_points`,`place`,`title`,`course_instance_id`,`period_id`)
VALUES(2,'2022-04-20',50,'NTP333','Practical Exam',2,1);

--TEST STUDENT INSTANCE
INSERT INTO `student_service`.`test_student_instance` (`id`, `is_graded`, `points`, `student_id`, `test_id`)
VALUES (1, false, 0, 1, 1);