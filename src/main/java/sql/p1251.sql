select product_id, round(sum(price) / sum(units), 2) as average_price from
(
    select A.product_id, A.price * B.units as price, B.units as units
    from Prices A
             join UnitsSold B on A.product_id = B.product_id and A.start_date <= B.purchase_date and A.end_date >= B.purchase_date
) as T
group by product_id