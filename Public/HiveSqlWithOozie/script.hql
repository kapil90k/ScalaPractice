create database kapil;
use kapil;
create table student(id int,name string) row format delimited fields terminated by ',';
load data local inpath '/home/edureka/Desktop/input' overwrite into table student;
select * from student;
