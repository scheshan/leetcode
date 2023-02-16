select A.name, B.bonus
from Employee A
left join Bonus B on A.empId = B.empId
where ifnull(B.bonus, 0) < 1000