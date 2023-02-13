select distinct(page_id) as recommended_page
from Likes A
where user_id in (
    select user2_id as user_id from Friendship where user1_id = 1
    union all select user1_id as user_id from Friendship where user2_id = 1
)
and not exists (
    select page_id from Likes B where B.user_id = 1 and B.page_id = A.page_id
)