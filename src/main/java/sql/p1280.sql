select A.student_id, A.student_name, B.subject_name, ifnull(C.attended_exams, 0) as attended_exams
from Students A
join Subjects B
left join
(
     select student_id, subject_name, count(1) as attended_exams
     from Examinations
     group by student_id, subject_name
) C on A.student_id = C.student_id and B.subject_name = C.subject_name
order by student_id, subject_name