select name as warehouse_name, sum(Width * Length * Height * units) as volume
from
(
    select A.name, A.units, B.Width, B.Length, B.Height from Warehouse A
    join Products B on A.product_id = B.product_id
) T
group by name