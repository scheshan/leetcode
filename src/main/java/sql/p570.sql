select name as name from
(
    select B.id, B.name from Employee A
    join Employee B on A.managerId = B.id
) T
group by id having(count(1) >= 5)