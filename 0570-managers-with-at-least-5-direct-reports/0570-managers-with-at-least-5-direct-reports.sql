# Write your MySQL query statement below
select E.name from Employee E inner join Employee E1 on E.id=E1.managerId group by E.id,E.name having count(E1.managerId) >=5;