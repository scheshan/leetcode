select A.firstName, A.lastName, B.city, B.state
from Person A
left join Address B on A.PersonId = B.PersonId