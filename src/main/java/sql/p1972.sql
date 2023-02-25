with T1 as (
    select caller_id as user_id, recipient_id as tid, call_time from Calls
    union all select recipient_id as user_id, caller_id as tid, call_time from Calls
),
T2 as (
    select A.user_id, day, T1.tid, A.call_time from
    (
        select user_id, date_format(call_time, '%Y-%m-%e') as day, min(call_time) as call_time
        from T1
        group by user_id, date_format(call_time, '%Y-%m-%e')
    ) A
    join T1 on A.user_id = T1.user_id and A.call_time = T1.call_time
),
T3 as (
    select A.user_id, day, T1.tid, A.call_time from
    (
        select user_id, date_format(call_time, '%Y-%m-%e') as day, max(call_time) as call_time
        from T1
        group by user_id, date_format(call_time, '%Y-%m-%e')
    ) A
    join T1 on A.user_id = T1.user_id and A.call_time = T1.call_time
)
select distinct T2.user_id from T2
join T3 on T2.day = T3.day and T2.user_id = T3.user_id and T2.tid = t3.tid