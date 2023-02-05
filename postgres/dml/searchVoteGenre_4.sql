select max(genre_4) as max,
count(genre_4)
from vote
group by (genre_4)
order by count desc
