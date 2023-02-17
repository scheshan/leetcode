select
school_id, ifnull(min(score), -1) as score
from Schools A
left join Exam B on A.capacity >= B.student_count
group by A.school_id