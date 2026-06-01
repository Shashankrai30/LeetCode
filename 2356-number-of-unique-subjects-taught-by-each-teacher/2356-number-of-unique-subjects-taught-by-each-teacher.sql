# Write your MySQL query statement below
-- select t1.teacher_id, (select count(distinct t2.subject_id) from Teacher t2 where t1.teacher_id=t2.teacher_id) as cnt from Teacher t1 group by t1.teacher_id ;
select teacher_id, count(distinct subject_id) as cnt from Teacher group by teacher_id;