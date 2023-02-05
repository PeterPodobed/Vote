select max(genre_3) as max,
count(genre_3)
from vote
group by (genre_3)
order by count desc
