select
A.id, ifnull(case when A.id % 2 = 0 then C.student else B.student end, A.student) as student
from
Seat A
left join Seat B on A.id = B.id - 1
left join Seat C on A.id = C.id + 1