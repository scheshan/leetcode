select
round(
(select count(1) from Delivery where order_date = customer_pref_delivery_date) * 100
/
(select count(1) from Delivery)
, 2) as immediate_percentage