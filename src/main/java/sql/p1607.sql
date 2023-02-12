select seller_name from Seller
where not exists (
    select 1 from Orders
    where Orders.seller_id = Seller.seller_id
    and sale_date >= '2020-01-01' and sale_date < '2021-01-01'
)
order by seller_name