
use springProject;
create table Category(
CategoryId int  AUTO_INCREMENT PRIMARY KEY,
CategoryName varchar(255),
tasks varchar(255)
);
create table Task(
TaskID int AUTO_INCREMENT PRIMARY KEY,
Title varchar(255),
TaskDescription varchar(255),
dueDate Date,
priority varchar(255),
completed boolean,
category_id int,
FOREIGN KEY (category_id) REFERENCES Category(categoryId)
)

