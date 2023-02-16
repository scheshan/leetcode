select question_id as survey_log  from (
    select question_id, rank() over(order by rate desc, question_id asc) as r
    from (
        select question_id, sum(case when answer_id is not null then 1 else 0 end) / sum(case when action = 'show' then 1 else 0 end) as rate
        from SurveyLog
        group by question_id
    ) T1
) T2 where r = 1