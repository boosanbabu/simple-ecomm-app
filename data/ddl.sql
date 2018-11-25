drop database studentdb;
create database studentdb;
use studentdb;
drop table if exists users;

create table academic_session
	( 
		academic_session_id int primary key auto_increment,
		start_date date,
		end_date date,
		session_label varchar(100),
		session_name varchar(100)
	);


-- users : Captures basic user info with password, staffs, 
create table users
	(
		user_id INT primary key auto_increment,
		primary_email varchar(100),
		user_name varchar(25),
		password varchar(255),
		enabled boolean
	);
create table staff
	(
		staff_id int primary key auto_increment,
		user_id int,
		first_name varchar(100),
		last_name varchar(100),
		suffix varchar(10),
		dob date,
		doj date,
		FOREIGN KEY (user_id)
        	REFERENCES users(user_id) on delete cascade
		);


	create table levels
	(
		level_id int primary key auto_increment,
		level_name varchar(50)
		);

drop table if exists classes;


create table classes
	(
		class_id int primary key auto_increment,
		level int,
		section varchar(2),
		class_teacher int,
        academic_session int,
		FOREIGN KEY (level)
	        REFERENCES levels(level_id),
		FOREIGN KEY (class_teacher)
	        REFERENCES staff(staff_id),
	    FOREIGN KEY(academic_session)
	    	REFERENCES academic_session(academic_session_id)
	);




create table subjects
	(
		subject_id int primary key auto_increment,
		subject_name int,
		syllabus varchar(10000),
		is_elective boolean,
		level_id int,
		FOREIGN KEY (level_id)
        	REFERENCES levels(level_id)
	);

-- user_persons : Mapping person_type and users with personal information
drop table if exists students;
create table students
	(
		student_id int primary key auto_increment,
		user_id int,
		first_name varchar(100),
		last_name varchar(100),
		suffix varchar(10),
		dob date,
		doj date,
		class int,

		FOREIGN KEY (user_id)
        	REFERENCES users(user_id) on delete cascade,

		FOREIGN KEY (class)
        	REFERENCES classes(class_id) on delete cascade
	);


drop table if exists students_electives;

create table students_electives
	(
		stud_elective_id int primary key auto_increment,
		student int,
		subject int,

		FOREIGN KEY (student)
        	REFERENCES students(student_id) on delete cascade,

		FOREIGN KEY (subject)
        	REFERENCES subjects(subject_id) on delete cascade);


drop table if exists roles;

-- roles : Mapping person_type and users with personal information
create table roles
	(
		role_id INT primary key auto_increment,
		role_name varchar(100)

	);

-- user_roles : Mapping person_type and users with personal information
drop table if exists user_roles;
create table user_roles
	(
		user_role_id INT primary key auto_increment,
		role_id INT,
		user_id INT,
		FOREIGN KEY (user_id)
	        REFERENCES users(user_id)
	        ON DELETE CASCADE,
	    FOREIGN KEY (role_id)
	        REFERENCES roles(role_id)
	        ON DELETE CASCADE
	);


drop table if exists tasks;
create table tasks
	(
		task_id int primary key auto_increment,
		task_name varchar(255),
		task_desc varchar(10000),
		is_active boolean default true,
		type varchar(100),
		created_at timestamp,
		due_date timestamp,
		last_modified_at timestamp,
		subject int,

		created_by int,
		FOREIGN KEY (created_by)
		        REFERENCES staff(staff_id),
        FOREIGN KEY (subject)
		        REFERENCES subjects(subject_id)
	);

drop table if exists student_tasks;

create table task_statuses
	(
		task_status_id int(2) primary key auto_increment,
		task_status varchar(25)
	);

insert into task_statuses(task_status_id,task_status) values (1,"Completed"), (2,"Pending"),(3,"Overdue"),(4,"Re-write");

create table student_tasks
	(
		student_task_id int primary key auto_increment,
		student_id int,
		task_id int,
		task_status int,
		review_status boolean,
		review_comment varchar(4000),

		FOREIGN KEY (student_id)
		    REFERENCES students(student_id),
		FOREIGN KEY (task_id)
	        REFERENCES tasks(task_id)
	        ON DELETE CASCADE,
		FOREIGN KEY (task_status)
		    REFERENCES task_statuses(task_status_id)
	);


