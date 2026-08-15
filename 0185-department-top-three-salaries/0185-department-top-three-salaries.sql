# Write your MySQL query statement below
select d.name as Department,e.name as Employee,e.salary as Salary from ( 
    select id,name,salary,departmentId, Dense_Rank() over(partition by departmentid order by salary desc) as ran from Employee
) e left join Department d on e.departmentId = d.id where e.ran<=3;