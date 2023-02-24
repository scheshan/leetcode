select business_id from
(
    select A.business_id from Events A
    join (
        select event_type, sum(occurences) / count(1) as c from Events
        group by event_type
    ) B on A.event_type = B.event_type
    where A.occurences > B.c
) T
group by business_id
having(count(1) > 1)