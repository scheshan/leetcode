select id, month, sum(salary) over(partition by id order by month range 2 preceding) as Salary
from Employee
where (id, month) not in (select id, max(month) from Employee group  by id)
order by id, month desc