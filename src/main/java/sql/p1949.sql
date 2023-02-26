with T1 as (
    select user1_id as user_id, user2_id as friend_id from Friendship
    union all
    select user2_id as user_id, user1_id as friend_id from Friendship
)
select
A.user1_id,
A.user2_id,
count(1) as common_friend
from Friendship A
join T1 B on A.user1_id = B.user_id
join T1 C on A.user2_id = C.user_id and B.friend_id = C.friend_id
group by A.user1_id, A.user2_id
having common_friend >= 3