select max(genre_5) as max,
count(genre_5)
from vote
group by (genre_5)
order by count desc
