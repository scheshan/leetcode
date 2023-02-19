with T1 as (
    select A.user_id, B.name, rank() over(order by count(1) desc, B.name asc) as r
    from MovieRating A
    join Users B on A.user_id = B.user_id
    group by A.user_id
),
T2 as (
    select A.movie_id, B.title, rank() over(order by sum(rating) / count(1) desc, B.title asc) as r
    from MovieRating A
    join Movies B on A.movie_id = B.movie_id
    where year(A.created_at) = 2020 and month(A.created_at) = 2
    group by A.movie_id
)
select name as results from T1 where r = 1
union all select title as results from T2 where r = 1