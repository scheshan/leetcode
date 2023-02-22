select user1_id, user2_id from (
    select user1_id, user2_id, rank() over(order by count(1) desc) as r from
    (
        select
        if(A.user_id < B.user_id, A.user_id, B.user_id) as user1_id,
        if(A.user_id > B.user_id, A.user_id, B.user_id) as user2_id
        from Relations A
        join Relations B on A.follower_id = B.follower_id and A.user_id != B.user_id
    ) T
    group by user1_id, user2_id
) T2 where r = 1