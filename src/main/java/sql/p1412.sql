with T1 as (
    select exam_id, max(score) as max_score, min(score) as min_score
    from Exam
    group by exam_id
),
T2 as (
    select distinct(A.student_id) from Exam A
    join T1 on A.exam_id = T1.exam_id and (A.score = T1.max_score or A.score = T1.min_score)
)
select A.student_id, A.student_name
from Student A
where A.student_id not in (select student_id from T2)
and A.student_id in (select distinct(student_id) from Exam)
order by student_id