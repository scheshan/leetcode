select A.dept_name, ifnull(B.student_number, 0) as student_number
from Department A
left join (
    select dept_id, count(1) as student_number
    from Student
    group by dept_id
) B on A.dept_id = B.dept_id
order by student_number desc, dept_name asc