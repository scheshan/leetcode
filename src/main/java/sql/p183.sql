select A.Name as Customers  from Customers A
where not exists
(
    select 1 from Orders B
    where A.id = B.CustomerId
)