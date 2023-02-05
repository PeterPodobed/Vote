select max(genre_2) as max,
count(genre_2)
from vote
group by (genre_2)
order by count desc
