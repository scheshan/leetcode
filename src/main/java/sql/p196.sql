delete A from Person A
join (
    select email, min(id) as id
    from Person
    group by email
    having(count(1) > 1)
) B
where A.email = B.email and A.id != B.id